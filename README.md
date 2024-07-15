# Tunetastic Music Application

## Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## About the Project

Tunetastic is a premium music streaming application designed to provide users with an exceptional music experience. Built using modern technologies, Tunetastic offers features like user authentication, playlist creation, premium subscriptions, and high-quality music streaming.

## Features

- User Registration and Login
- Premium and Non-Premium User Differentiation
- Playlist Creation and Management
- Song Playback
- Payment Integration for Premium Subscriptions
- Responsive and Premium User Interface

## Technologies Used

- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **Payment Gateway**: Razorpay
- **Template Engine**: Thymeleaf
- **Other**: Spring Tool Suit, Maven, etc...

## Getting Started

To get a local copy up and running, follow these steps.

### Prerequisites

Ensure you have the following installed:

- Java JDK 17
- Maven
- MySQL

### Installation

1. **Clone the repository**
    ```sh
    git clone https://github.com/sathishsegu/tunetastic.git
    cd tunetastic
    ```

2. **Configure the Database**
    - Create a MySQL database named `tunetastic`
    - Update the database configuration in `src/main/resources/application.properties`
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/tunetastic
      spring.datasource.username=your-username
      spring.datasource.password=your-password
      spring.jpa.hibernate.ddl-auto=update
      ```

3. **Install Dependencies**
    ```sh
    mvn clean install
    ```

4. **Run the Application**
    ```sh
    mvn spring-boot:run
    ```

## Usage

1. Open your browser and navigate to `http://localhost:8080`.
2. Register a new user or log in with existing credentials.
3. Explore the features, create playlists, and enjoy the music.

## Contributing

Contributions are what make the open source community such an amazing place to be, learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/your-feature`)
3. Commit your Changes (`git commit -m 'Add some feature'`)
4. Push to the Branch (`git push origin feature/your-feature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Sathish Kumar Segu - [@your-twitter-handle](https://x.com/segusathish) - sathishsegu123@gmail.com

Project Link: [https://github.com/sathishsegu/tunetastic](https://github.com/sathishsegu/tunetastic)
