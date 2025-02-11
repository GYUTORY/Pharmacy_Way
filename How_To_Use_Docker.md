
## 해당 예시는 싱글컨테이너의 예시이다.


---

# 1. Docker 설정 및 로그인 확인 

### 내용
#### 1. docker와 docker-compose의 버전을 각각 확인한다.
#### 2. 작성자 기준, Mac 환경이기에 Docker-Compose가 함께 설치된다. 
#### 3. docker-hub에 기본적으로 가입이 되어있어야 하므로, 로그인 처리를 진행한다.

```bash 
➜  ~ docker -v
Docker version 20.10.24, build 297e128

➜  ~ docker-compose -v
Docker Compose version v2.17.2

➜  ~ docker login
Authenticating with existing credentials...
Login Succeeded
```

---

# 2. build.gradle 수정하기

## 내용
#### 1. `./gradlew build`(Mac) , `gradlew build`(Window)를 하게 되면, root Dir의 `build/libs/`에 빌드된 jar 파일이 생성된다. 
-> 해당 jar 파일의 산출물 이름을 지정하기 위해 build.gradle 파일 내 아래 코드를 각 산출물에 맞게 수정한다.   


```java 
bootJar {
    archiveFileName = "나의_산출물.jar"
}
```

---

# 3. Docker File 작성하기
- 코드 내 Dockerfile을 확인한다.

---

# 4. Docker Image Build 하기

### 내용
1. 완료되었다면, 아래와 같이 FINISHED와 같이 표기된다. 

```bash 
➜  ~ docker build-t ${사용자ID}/${Repository 이름}
[+] Building 10.3s (8/8) FINISHED 
....
```

---

# 5. Docker Image 확인하기

### 내용
1. docker images 명령어를 통해 정상 생성되었는지 확인한다.

```bash 
➜  ~  docker images
REPOSITORY                      TAG       IMAGE ID       CREATED          SIZE
${사용자ID}/${Repository 이름}   latest    생성된_이미지_ID   40 seconds ago   522MB

```

---

# 6. Docker run 명령어를 통해 컨테이너 생성 및 시작

```bash 
➜  ~  docker run ${사용자ID}/${Repository 이름} -p 8080:8080
```

---

# 7. Docker PS 확인

```bash
➜  ~ docker ps
CONTAINER ID   IMAGE                           COMMAND                  CREATED          STATUS          PORTS     NAMES
${컨테이너ID}   ${사용자ID}/${Repository 이름}   ${Dockerfile의 ENTRYPOINT}   56 seconds ago   Up 55 seconds             ${임의 지정된 컨테이너명}
```
