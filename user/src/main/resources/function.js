const express = require('express');
const jwt = require('jsonwebtoken');
const cookieParser = require('cookie-parser');

const app = express();

app.use(express.json());
app.use(cookieParser());

const secretKey = "khBfXWLgglDDWijP3yIMNRTVLCus5BoLD9lGlyXTgtaOG68G7YreTCG4qATj9hkDWFkK0ADUJAy5+QG3KAUKR0hzjxcVFEMwYc7XnPH7JUIL+kfAYcPzlo2iT9ZzcNVz3/SnbrEELQ5x/arqataa4W6cxv6QAvuaAVxDEun53SebHriEs1t+XmOz88S2DUEMu+9QuPX7N5J/mOjutgr6LGrnm6dc/eln8/gzc6h4owY3euerPoFs/LzT0os/LXtEtI55W1H5HaiNtmr1HbSRgPzuYMMWr+npDKFpYsbq+SIHLlEtocFQdYaagosgcdUIibie6eLe8s9aKrYrcvJTDXxgyWYNWYGWs8CZ4ClCDzE=";

app.post('/login', (req, res) => {
    // Validate the user's credentials, and if they are valid, generate a token
    const user = { id: 123, username: 'example_user' };
    const token = jwt.sign(user, secretKey, { expiresIn: '1h' });

    // Set the token in a cookie
    res.cookie('jwt', token, { httpOnly: true, maxAge: 3600000 }); // Max Age in milliseconds
    res.json({ message: 'Logged in successfully' });
});

app.listen(63342, () => {
    console.log('Server is running on port 3000');
});
