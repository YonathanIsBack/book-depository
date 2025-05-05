import DatabaseConfig from "../config/DatabaseConfig.js";
import Publisher from "../model/Publisher.js";

class PublisherService {
    #model;
    constructor() {
        this.#model = Publisher;
    }

    async createPublisher(publisher) {
        return await DatabaseConfig.getConnection().transaction(async transaction => {
            return await this.#model.create({name: publisher.name}, {transaction})
        });
    }
}

export default PublisherService;