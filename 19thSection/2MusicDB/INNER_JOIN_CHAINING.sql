CREATE TABLE songs (_id INTEGER PRIMARY KEY, track INTEGER, title TEXT NOT NULL, album INTEGER);
CREATE TABLE albums (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, artist INTEGER);
CREATE TABLE artists (_id INTEGER PRIMARY KEY, name TEXT NOT NULL);

--------------------------------------------------------

 SELECT artists.name, songs.title FROM artists 
 INNER JOIN albums ON artists._id = albums.artist
 INNER JOIN songs ON albums._id = songs.album


 SELECT artists.name, songs.title FROM artists 
 INNER JOIN albums ON artists._id = albums.artist
 INNER JOIN songs ON albums._id = songs.album
 WHERE songs.title LIKE "%doctor%";
 
 
 
--------------------COPIED------------------------------ 
 SELECT artists.name, albums.name, songs.track, songs.title from songs
 INNER JOIN albums ON songs.album = albums._id
 INNER JOIN artists ON albums.artist = artists._id
 WHERE albums._id = 19
 ORDER BY artists.name, albums.name, songs.track;
