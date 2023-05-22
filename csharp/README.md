# C# with .NET Hangman API 

In this partial implementation the technologies used are:

- C#
- .NET 6
- [ASP.NET Core](https://github.com/dotnet/aspnetcore)
- [XUnit](https://xunit.net/) 
  - XUnit is a .NET testing framework.

## How to: Run Application

- Please skip Installer sections if you already have the following installed:
  - .NET 6

### Manual Installation macOS & Windows

1. Install .NET

To install .NET 6 on Windows or macOS, follow these steps:

- Visit the dotnet website at https://dotnet.microsoft.com/en-us/download/dotnet/6.0.

- Click on the SDK installer that is relevant for your computer. A download should begin with the installer.

- Follow the installation wizard with the default settings selected.

2. Verify installation

- Open a terminal/command line

- type `dotnet --version`
  - You should see `6.0.402` or similar appear.


### Package Installation

Installation can also be completed using a package manager.
- Chocolatey: Windows
- Homebrew: macOS
- https://learn.microsoft.com/en-us/dotnet/core/install/linux?WT.mc_id=dotnet-35129-website: linux

This approach can be more problematic if a problem occurs and requires more terminal/command line experience. If using WSL with windows we can also use the linux package managers depending on the distribution installed on the WSL.

## Running the dotnet Application

To run the service using the .NET runtime, follow these steps:

- Navigate to the root directory of your c# service project in the terminal/command line. For this repository the command would be:
  - `cd csharp`

1. Run the following command to install the services dependencies: `dotnet restore`
2. Run the following command to start up the application: `dotnet run --project src/api/api.csproj`
  - It is also possible to `cd` into the `src/api` folder and instead run `dotnet run`.
3. (optional) Run the following command to execute the unit tests: `dotnet test`

The app should now be available at: `http://localhost:4567`

Happy coding :) 