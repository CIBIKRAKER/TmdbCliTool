# TMDB CLI Tool

A command-line tool that fetches and displays movies from The Movie Database (TMDB) API.

## Tech Stack

- Java 21
- Apache Commons CLI
- org.json

## Prerequisites

- Java 21
- A free TMDB API key from [themoviedb.org](https://www.themoviedb.org/settings/api)

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/cibikraker/TmdbCliTool.git
cd TmdbCliTool
```

### 2. Configure your API key

Copy the example config file and add your API key:
```bash
cp config.properties.example config.properties
```

Edit `config.properties`:
```properties
apiKey=your_tmdb_api_key_here
```

### 3. Build the jar
```bash
./gradlew jar
```

### 4. Run the tool
```bash
java -jar build/libs/TmdbCliTool-1.0-SNAPSHOT.jar --type popular
```

## Usage
```bash
java -jar build/libs/TmdbCliTool-1.0-SNAPSHOT.jar --type [popular|top|upcoming|playing]
```

### Options

| Option | Description | Default |
|--------|-------------|---------|
| --type | Type of movies to display | popular |

### Examples
```bash
# Popular movies
java -jar build/libs/TmdbCliTool-1.0-SNAPSHOT.jar --type popular

# Top rated movies
java -jar build/libs/TmdbCliTool-1.0-SNAPSHOT.jar --type top

# Upcoming movies
java -jar build/libs/TmdbCliTool-1.0-SNAPSHOT.jar --type upcoming

# Now playing movies
java -jar build/libs/TmdbCliTool-1.0-SNAPSHOT.jar --type playing
```

## Movie Types

| Type | Description |
|------|-------------|
| popular | Most popular movies right now |
| top | Top rated movies of all time |
| upcoming | Movies coming soon |
| playing | Movies currently in theaters |
