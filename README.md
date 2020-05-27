# Indian Jokes API
This is the repository of the indian-jokes-api live [here](https://indian-jokes-api.herokuapp.com/jokes/random). 

*Note* - I make no claim on ownership of these files, nor do I necessarily endorse the jokes in them. This api is provided for fun purposes. 

## Supported API endpoints
Base URL -> https://indian-jokes-api.herokuapp.com



|            Endpoint           | Method |                       Description                       |
|:-----------------------------:|:------:|:-------------------------------------------------------:|
|          /categories          |   GET  | Get a list of supported categories along with their IDs |
|        /categories/{id}       |   GET  |          Get a specific category using the ID.          |
|     /categories/{id}/jokes    |   GET  |              Get all jokes of that category             |
| /categories/{id}/jokes/random |   GET  |            Get a random joke of that category           |
|             /jokes            |   GET  |               Get a list of all the jokes               |
|         /jokes/random         |   GET  |                    Get a random joke                    |
|          /jokes/{id}          |   GET  |            Get a specific joke using the ID.            |


## Contributing
 
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D


## Updating the database
If you want, you may include a scrapper or any source that you used to get the jokes from. If you want to add a scrapper, add it to the `scrapper` folder with name `<category>.py`. 

To include the jokes in the database:
- Create a file in the `server/src/main/resources/` folder with name `<category>.txt`. 
- Add an entry in the `jokes_meta.txt` file as `<above-created-file>.txt`.


PS - Classic indian jokes preferred :p

## License
This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.