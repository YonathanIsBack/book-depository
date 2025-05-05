import {Router} from "express";
import AuthorController from "../controller/AuthorController.js";
import PublisherController from "../controller/PublisherController.js";

const indexRoute = () => {
    const router = new Router();
    const authorController = new AuthorController();
    const publisherController = new PublisherController();

    router.get('/', (request, response) => {
        response.status(200).json({message: "Hey"});
    })
    router.post('/author', authorController.create);
    router.put('/author', authorController.updateBalance);
    router.post('/publisher', publisherController.create);

    return router;
}

export default indexRoute;