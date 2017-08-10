# Run Cassandra
```
docker run -d -p 9042:9042 --name cassandra cassandra
```

# Run app
```
mvn spring-boot:run -Drun.jvmArguments="-Dcassandra.contact-points=localhost -Dcassandra.port=9042"
```

# Init data
* jeu de données partiel : http://files.data.gouv.fr/sirene/sirene_2017219_E_Q.zip
* jeu de données complet : http://files.data.gouv.fr/sirene/sirene_201707_L_M.zip
* infos : http://sirene.fr/static-resources/doc/dessin_L2_description_complete.pdf?version=1.18
```
curl -O http://files.data.gouv.fr/sirene/sirene_201707_L_M.zip
unzip sirene_201707_L_M.zip
rm sirene_201707_L_M.zip
cut -d';' -f1,2,3 *.csv  > sirene.csv
docker cp sirene.csv cassandra:sirene.csv
docker exec cassandra cqlsh -e "COPY poc.sirene (siren, numinterne, adressenormligne1) from 'sirene.csv' with delimiter = ';';"
```

# Test local
ouvrir http://localhost:8080/api/sirene

Au démarrage un dump des entrées est fait dans la console et permet de valider  toute la chaine :
 - fonctionnalité de client REST via Feign
 - fonctionnalité de serveur REST via Jersey
 - requête Cassandra
