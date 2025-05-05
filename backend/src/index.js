import express from 'express';
import bodyParser from "body-parser";
import indexRoute from "./route/indexRoute.js";

const app = express();
const port = 3000;

app.use(bodyParser.json());
app.use(indexRoute());

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})