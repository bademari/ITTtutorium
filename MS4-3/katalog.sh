# Daten aus der Datenbank holen

mysqldump --xml -u inttentwickler -pITT11pra! -h localhost  Allgold > dbkatalog.xml

#XSL-Transformation durchführen

java -cp /home/inttentwickler/Downloads/saxon9he.jar net.sf.saxon.Transform -o:katalog.fo dbkatalog.xml katalog.xsl


#Fo-Transformation durchführen

fop katalog.fo katalog.pdf


#erstellte PDF-Datei anzeigen

xdg-open katalog.pdf
