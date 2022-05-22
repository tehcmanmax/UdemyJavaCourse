--challenges_SQLite.sql

--1
 SELECT title, albums.name FROM songs INNNER JOIN albums ON album = albums._id WHERE albums.name = 'Forbidden';
/*
title                   name                
----------------------  --------------------
The Illusion of Power   Forbidden           
Sick and Tired          Forbidden           
Can't Get Close Enough  Forbidden           
Forbidden               Forbidden           
Shaking Off the Chains  Forbidden           
Get a Grip              Forbidden           
Kiss of Death           Forbidden           
Guilty as Hell          Forbidden           
Rusty Angels            Forbidden           
I Won't Cry for You     Forbidden    
*/

--2
 SELECT title, albums.name, track FROM songs INNNER JOIN albums ON album = albums._id WHERE albums.name = 'Forbidden'
	ORDER BY track;
/*
title                   name                  track 
----------------------  --------------------  ------
The Illusion of Power   Forbidden             1     
Get a Grip              Forbidden             2     
Can't Get Close Enough  Forbidden             3     
Shaking Off the Chains  Forbidden             4     
I Won't Cry for You     Forbidden             5     
Guilty as Hell          Forbidden             6     
Sick and Tired          Forbidden             7     
Rusty Angels            Forbidden             8     
Forbidden               Forbidden             9     
Kiss of Death           Forbidden             10   
*/

--3
 SELECT title FROM songs INNER JOIN albums ON album = albums._id
    INNER JOIN artists ON albums.artist = artists._id
    WHERE artists.name = "Deep Purple";
/*
title                                                        
-------------------------------------------------------------
Love Help Me (2000 Digital Remaster)                         
Might Just Take Your Life                                    
And The Address (2000 Digital Remaster)                      
Fireball (Take 1 - Instrumental)                             
Maybe I'm a Leo                                              
Fireball                       
...
*/

--4
 UPDATE artists SET name = "One Kitten" WHERE name LIKE
  	"Mehi%";

--5
 SELECT name FROM artists WHERE name LIKE   "One%";
name      
/*
----------
One Kitten
*/

--6
 SELECT title FROM songs INNER JOIN albums ON album = albums._id INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = "Aerosmith" ORDER BY title;

--7
SELECT COUNT(*) FROM songs INNER JOIN albums ON album = albums._id INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = "Aerosmith" ORDER BY title;
/*
COUNT(*)
--------
151     
*/

--8
 SELECT DISTINCT title FROM songs INNER JOIN albums ON album = albums._id INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = "Aerosmith" ORDER BY title;
 
--9
SELECT COUNT(DISTINCT title ) FROM songs;
SELECT  COUNT(DISTINCT title) FROM songs INNER JOIN albums ON album = albums._id INNER JOIN artists ON albums.artist =
artists._id WHERE artists.name = "Aerosmith" ORDER BY title;

--10
SELECT  COUNT(DISTINCT artists.name), COUNT(DISTINCT album) FROM songs INNER JOIN albums ON album = albums._id INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = "Aerosmith" ORDER BY title;
/*
COUNT(DISTINCT artists.name)  COUNT(DISTINCT album)
----------------------------  ---------------------
1                             13   
*/
