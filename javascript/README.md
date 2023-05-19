# Javascript Hangman API 

In this partial implementation the technologies used are:

- Node version 18
- Node Package Manager (included with node)
- [Express](https://expressjs.com/)
  - Express is a micro web framework that is used to expose API endpoints.
- [Jest](https://jestjs.io/) 
  - Jest is a Javascript testing framework focused on simplicity.

## How to: Run Application

- Please skip Installer sections if you already have the following installed:
  - Node
  - NPM


### Manual Installation macOS & Windows

1. Install Node

To install Node 18 on Windows or macOS, follow these steps:

- Visit the Node website at https://nodejs.org/en/download.

- Make sure the LTS (long-term support) tab is selected 

- Click on the installer than is relevant for your computer. A download should begin with the pkg/msi.

- Follow the installation wizard with the default settings selected.

2. Verify installation

- Open a terminal/command line

- type `node -v`
  - You should see `V18.12.0` or similar appear.


### Package Installation

Installation can also be completed using a package manager.
- Chocolatey: Windows
- Homebrew: macOS
- https://nodejs.org/en/download/package-manager: linux

This approach can be more problematic if a problem occurs and requires more terminal/command line experience. If using WSL with windows we can also use the linux package managers depending on the distribution installed on the WSL.

### Node Version Manager

The last approach for installing node can be completed using Node Version Manager (nvm). This is only available using linux or macOS and can be completed follow the guide [here](https://github.com/nvm-sh/nvm).

Once installed you can simply type:

```
nvm install 18
nvm use 18
```

## Running the Javascript Application

To run the Javascript service using node & npm, follow these steps:

- Navigate to the root directory of your Javascript service project in the terminal/command line. For this repository the command would be:
  - `cd javascript`

1. Run the following command to install the services dependencies: `npm install`
2. Run the following command to start up the application: `npm start`
3. (optional) Run the following command to execute the unit tests: `npm test`

The app should now be available at: `http://localhost:4567`

Happy coding :) 