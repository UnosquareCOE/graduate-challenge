from flask import Flask
from controllers.game import mod as game_module

app = Flask(__name__)

app.register_blueprint(game_module)

if __name__ == '__main__':
    app.run(debug=True, host="0.0.0.0", port=4567)