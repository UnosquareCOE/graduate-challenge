# Python Hangman API 

In this partial implementation the technologies used are:

- Python version 3.11.*
- PIP (python package manager)
- [Flask](https://flask.palletsprojects.com/en/2.3.x/)
  - Flask is a micro web framework that is used to expose API endpoints.
- [unittest](https://docs.python.org/3/library/unittest.html) 
  - unittest is a Python testing framework.

## How to: Run Application

- Please skip Installer sections if you already have the following installed:
  - Python
  - PIP


### Manual Installation macOS & Windows

1. Install Python

To install python 3.11.* you can follow the below steps:

- Visit the python website download at https://www.python.org/downloads/release/python-3113/.

- Click on the installer that is relevant for your computer. A download should begin with the pkg/exe.

- Follow the installation wizard with the default settings selected.

2. Install PIP (it should be included, if you don't have it please see https://pip.pypa.io/en/stable/installation/)

3. Verify installation

- Open a terminal/command line

- type `python --version`
  - You should see `3.11.3` or similar appear.

## Running the Javascript Application

To run the python service using python & pip, follow these steps:

- Navigate to the root directory of your python service project in the terminal/command line. For this repository the command would be:
  - `cd python`

### Optional :
1. we recommend virtualenv to avoid global package installation issues. To install virtualenv we need to run `pip install virtualenv`
2. Run the following command to create the virtual directory: `python -m venv ./`
3. We can start the virtualenv with `source bin/activate` on macOS or Linux and `.\venv\Scripts\activate` on windows.                        

### Steps to run
1. Run the following command to install packages: `pip install -r requirements.txt`
2. Run the following command to start up the application: `python main.py`
3. (optional) Run the following command to execute the unit tests: `python -m unittest`

The app should now be available at: `http://localhost:4567`

Happy coding :) 