# Hi there !
Inspired by when2meet, Let's meet is a free and open-source app that allows you and your friends to find a date to meet. From now on, there is no need to spend hours and hours trying to find a suitable day for everyone.

---

# How to run ?
In the case you want to install and run your own version of Let's Meet, you just need to follow these few steps

## 1. Install docker
Let's Meet uses docker to perform easy, fast and efficient deployment

## 2. Fill compose.yaml
You'll find a compose.yaml file at the root of this project. 
In this file, two properties used as environment variables  are intentionally 
left blank for security purpose : *DB_USER* and *DB_PASSWORD*. Fill it with whatever you want.

## 3. Run it
Open a command prompt, run *docker compose build* and *docker compose up -d* then enjoy.

---

### Miscellaneous
Feel free to tweak whatever you want in the app to match your needs :) 
