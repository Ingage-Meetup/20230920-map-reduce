# Set up the project

1. Ensure Python 3.x and Pip are installed:


2. Clone the template and navigate into the project directory:

```
git clone <repository_url> my_project
cd my_project
```


3. Set up a virtual environment (recommended) and activate it.

On linux, run the following commands:

NOTE: You may need to prefix the apt-get and apt commands with `sudo` to give appropriate permissions to install python
```
apt-get update
apt install python3.10-venv
python3 -m venv venv
source venv/bin/activate
```

On Windows, run the following commands:

```
python3 -m venv venv
venv\Scripts\activate
```

If python3 is not found run `python3` by itself to install from the windows store

4. Install project dependencies from the `requirements.txt` file.

```
pip install -r requirements.txt

```

# Run the application

## Main App

```
python3 app/main.py

```

## Tests

### Using built-in unittest

```
python -m unittest tests/test_main.py

```
### Using pytest

```
pytest

```

# My Python 3 Project

Replace this with a brief description of your project.




