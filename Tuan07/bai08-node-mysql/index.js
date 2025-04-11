const express = require('express');
const mysql = require('mysql');
const app = express();

const connection = mysql.createConnection({
  host: process.env.DB_HOST || 'localhost',
  user: process.env.DB_USER || 'user',
  password: process.env.DB_PASSWORD || 'password',
  database: process.env.DB_NAME || 'testdb'
});

connection.connect(err => {
  if (err) {
    console.error('Database connection failed:', err.stack);
    return;
  }
  console.log('Connected to MySQL database.');
});

app.get('/', (req, res) => {
  connection.query('SELECT NOW() AS now', (err, results) => {
    if (err) throw err;
    res.send(`MySQL Time: ${results[0].now}`);
  });
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});
