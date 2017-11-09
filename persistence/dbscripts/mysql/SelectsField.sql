SELECT * from Cinemas WHERE (name = *);
SELECT * from Cinemas WHERE (city = *);
SELECT * from Cinemas WHERE (address = *);
SELECT * from Cinemas WHERE (phone = *);

SELECT * from Movies WHERE (born = *);
SELECT * from Movies WHERE (country = *);
SELECT * from Movies WHERE (name = *);
SELECT * from Movies WHERE (duration = *);
SELECT * from Movies WHERE (rating = *);

SELECT * FROM Sessions LEFT JOIN Cinemas;
SELECT * FROM Sessions RIGHT JOIN Cinemas;
SELECT * FROM Sessions FULL JOIN Cinemas;