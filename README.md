<p align="center"> 
  <img src="/docs/images/n11.png" alt="HAR Logo" width="80px" height="80px">
    <img src="docs/images/patika.png" alt="HAR Logo" width="80px" height="80px">
</p>

<h1 align="center"> n11-talenthub-bootcamp </h1>
<h3 align="center"> Graduation-Project Loan System </h3>  

</br>

<p align="center"> 
  <img src="docs/images/loanf.gif" alt="Sample signal" width="60%" height="30%">
</p>

<!-- TABLE OF CONTENTS -->
<h2 id="table-of-contents"> :book: İçerik</h2>

<details open="open">
  <summary>İçerik</summary>
  <ol>
    <li><a href="#hakkinda"> ➤ Proje Hakkında</a></li>
    <li><a href="#teknolojiler"> ➤ Kullanılan Teknolojiler</a></li>
    <li><a href="#gereklilikler"> ➤ Gereklilikler</a></li>
     <li>
      <a href="#kurulum"> ➤ Kurulum</a>
      <ul>
        <li><a href="#on-bilgiler">Ön Bilgiler</a></li>
        <li><a href="#git-kurulum">Git ile Kurulum</a></li>
        <li><a href="#docker-kurulum">Docker ile Kurulum</a></li>
        <li><a href="#npm-kurulum">Frontend Npm Kurlumu</a></li>
      </ul>
    </li>
    <li><a href="#klasor-yapisi"> ➤ Klasör Yapısı</a></li>
    <li><a href="#endpoint"> ➤ Endpointler</a></li>
    <li><a href="#swagger"> ➤ Swagger Dokümantasyon Görüntüsü</a></li>
    <li>
      <a href="#preprocessing"> ➤ Preprocessing</a>
      <ul>
        <li><a href="#preprocessed-data">Pre-processed data</a></li>
        <li><a href="#statistical-feature">Statistical feature</a></li>
        <li><a href="#topological-feature">Topological feature</a></li>
      </ul>
    </li>
    <!--<li><a href="#experiments">Experiments</a></li>-->
    <li><a href="#results-and-discussion"> ➤ Results and Discussion</a></li>
    <li><a href="#references"> ➤ References</a></li>
    <li><a href="#contributors"> ➤ Contributors</a></li>
  </ol>
</details>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- ABOUT THE PROJECT -->
<h2 id="hakkinda"> :pencil: Proje Konusu</h2>

<p align="justify"> 
<b>Proje Konusu:</b>
Bir kredi başvuru sistemi için, kredi başvuru isteklerini alıp ilgili kriterlere göre müşteriye kredi
sonucunu dönen servisin içinde yer alacak restful bir uygulamanın Spring Boot framework
kullanılarak yazılması ve isteğe bağlı olarak önyüzünün yazılması<br/><br/>
<b>Gereksinimler:</b><br/>
<b>Backend:</b><br/>
●Kimlik numarası, ad-soyad, aylık gelir, telefon bilgileri, doğum tarihi ve teminat(opsiyonel)
kimlik numarasıyla daha önceden yazıldığı varsayılan kredi skoru servisine gidilir ve ilgili
kişiye ait kredi skoru alınarak aşağıdaki kurallara göre kullanıcıya kredi sonucu gösterilir.
(Onay veya Red olarak iki seçenek olabilir.)<br/><br/>
<b>Frontend (opsiyonel):</b><br/>
●Kimlik numarası, ad-soyad, aylık gelir, telefon bilgileri, doğum tarihi ve teminat(opsiyonel)
bilgileri form ile alınır ve kullanıcıya kredi sonucu ve kredi limiti gösterilir.
●(JavaScript, HTML, CSS en basit şekilde yeterlidir, isteğe bağlı olarak front-end framework
kullanılabilir. Arayüz tasarımı ve deneyimi size bırakılmıştır.)

</p>


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- PREREQUISITES -->
<h2 id="teknolojiler"> :fork_and_knife: Kullanılan Teknolojiler</h2>

[![made-with-java](https://img.shields.io/badge/Made%20with-Java-green.svg)](https://www.python.org/) <br>
[![Made withJupyter](https://img.shields.io/badge/Made%20with-Java%20Spring%20Boot-success?style=for-the-badge&logo=Java)](https://jupyter.org/try) <br>

<!--This project is written in Python programming language. <br>-->
Projede kullanılan diğer teknolojiler:

* Java 11
* Maven
* Spring Boot Actuator
* Spring Boot MongoDB
* Spring Boot Validation
* Spring Boot Web
* Swagger API
* Lombok
* MapStruct
* React.js
* Npm
* Docker

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- PREREQUISITES -->
<h2 id="gereklilikler"> :fork_and_knife: Gereklilikler</h2>

<!--This project is written in Python programming language. <br>-->
Projede kullanılan diğer teknolojiler:
* <a href="https://www.oracle.com/java/technologies/downloads/#java11"> JDK11+</a>
* <a href="https://maven.apache.org/download.cgi"> Maven</a>
* <a href="https://www.docker.com/"> Docker</a> (dockerized için)
* <a href="https://www.npmjs.com/"> Npm</a> (frontend için)
* <a href="https://nodejs.org/en/download/"> NodeJs</a> (frontend için)


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- PREPROCESSING -->
<h2 id="kurulum"> :hammer: Kurulum</h2>

<p align="justify"> 
Projeyi lokal suncunuza kurmak için 2 yol vardır. Github deposundan çekebilirsiniz veya docker ile çalıştırabilirsiniz. Proje kurulumuna başlamadan önce bazı önemli bilgilere ihtiyacınız var.
</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3 id="on-bilgiler"> :hammer: Ön Bilgiler</h2>

<p align="justify"> 
Proje de kullanılan portlar:
 <ol>
    <li><b>Backend Port:</b> 8084</li> 
    <li><b>Frontend Port:</b> 9090</li>
    <li><b>MongoDb Port:</b> 27017</li>
  </ol>

Lokalinizde mongoDb kuruluysa veritabanı ayarlarını application-default.yml dosyasından yapmalısınız. Eğer mongoDb kurulu değilse lütfen docker-compose ile kurulum gerçekleştirin.
</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3 id="git-kurulum"> :hammer: Git ile Kurulum</h2>

<p align="justify"> 
1. Öncelikle projeyi GitHub deposundan klonlayın.

    git clone https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-byofficial.git

2.Maven ile bağımlılıkların yümlenmesini bekleyin.<br/>
3.a Lokalinizde MongoDb varsa aşağıdaki ayarları güncelleyin.<br/>

    ./src/main/resources/application-default.yml

Yukarıdaki dosyanın 12-20 satırlarını aşağıdaki gibi düzenleyin ve kendi mongoDb veritabanı ayarlarınızı yapılandırın.(Girintiler önemlidir. Aşağıdaki bilgileri yazarken kıvırcık parantezleri kaldırın)

      data:
        mongodb:
            port: {port_numaranız}
            host: {host_bilgisi}
            authentication-database: admin
            username: {kullanıcı_adı}
            database:{veritabanı_adı}
            password: {parola}
            auto-index-creation: true

3.b Eğer lokal mongoDb sunucunuz yoksa 12-20 satırları aşağıdaki gibi düzenleyin ve uzak sunucuya bağlanın. Eğer bu yöntemi tercih ederseniz mongoDb sunucu cloud üzerinde tutulacaktır.

      data:
        mongodb:

            uri: mongodb+srv://javamongop:WcnhMU1Uaz166@testc.k0o49.mongodb.net/dbSpringProject?retryWrites=true&w=majority
         
            auto-index-creation: true

3.c Eğer isterseniz docker-compose ile mongodb imajını çalıştırabilirsiniz. Bunun için sadece terminali açıp projenin olduğu kök dizine gitmeniz gerekmektedir.

    cd n11-talenthub-bootcamp-graduation-project-byofficial

Daha sonra aşağıdaki komutu çalıştırın ve projeyi docker ortamında çalıştırın.

    docker-compose up

4.Frontend sisteminin çalışabilmesi için npm ile paket kurulumu yapılmalıdır. Bunun npm ile kurulum bölümüne bakabilirsiniz.

</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3 id="docker-kurulum"> :hammer: Docker ile Kurulum</h2>

<p align="justify">
1.Projeyi docker ile çalıştırmak için öncelikle terminal ekranını açın ve projenin kök klasörüne gidin.

    cd n11-talenthub-bootcamp-graduation-project-byofficial

2.Kök klasöre gittikten sonra aşağıdaki komutu yazın ve docker-compose işleminin tamamlanmasını bekleyin.

    docker-compose up

3.Docker kurulumu tamamlandıktan sonra backend servisleri varsayılan olarak 8084 portunda, frontend servisleri ise 9090 portunda çalışacaktır. Frontend kurulumu tamamlanması için lokalinizde nodejs ve npm yüklü olmalıdır!
</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3 id="npm-kurulum"> :hammer: Npm ile Frontend Kurulum</h2>

<p align="justify">
1.Frontend projesinin çalışabilmesi için npm ile kurulumu gerekmektedir. Bunun için öncelikle nodejs ve npm paket yöneticisini yüklemelisiniz.

    ./src/frontend/

2.Yukarıdaki dizine terminal ekranını kullanarak gidin.

    npm install

Yukarıdaki komutu çalıştırarak tüm npm bağımlılıklarının yüklenmesini bekleyin.<br/>

3.Modül kurulumundan sonra aşağıdaki komut ile projeyi başlatın.

    npm start
Proje başladıktan sonra varsayılan çalışma portu 3000 dir. Frontend projesinin çalışabilmesi için backend projesinin ve veritabanı sunucunun çalışır olması gerekmektedir.

4.Eğer backend projesinin varsayılan 8084 çalışma portunu değiştirdiyseniz lütfen frontend projesinin portunu da güncelleyin. Frontend projesi port ayarı için aşağıdaki dosya yoluna gidin.

    ./src/frontend/src/constants/index.js

Yukarıdaki dosyadan api servisi için linki güncelleyin.

</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- :paw_prints:-->
<!-- FOLDER STRUCTURE -->
<h2 id="klasor-yapisi"> :cactus: Klasör Yapısı</h2>

    code
    .
    │
    ├── src
    │   ├── frontend
    │   │   ├── public
    │   │   │   ├── assets
    │   │   │   └── bootstrap
    │   │   │   └── plugins
    │   │   ├── src
    │   │       ├── component
    │   │       └── constants
    │   │       └── pages
    │   │
    │   ├── main
    │   │   ├── java
    │   │   │   ├── com.n11.graduationproject
    │   │   │       ├── config
    │   │   │       ├── controller
    │   │   │       ├── dto
    │   │   │       │   └── request
    │   │   │       │   └── response
    │   │   │       ├── exception
    │   │   │           └── customer
    │   │   │           └── loan
    │   │   │       ├── mapper
    │   │   │       ├── model
    │   │   │           └── enums
    │   │   │       ├── repository
    │   │   │       ├── service
    │   │   │           └── impl
    │   │   ├── resources
    │   │       ├── application-default.yml
    │   │
    │   ├── test
    │

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- DATASET -->
<h2 id="endpoint"> :floppy_disk: Endpointler</h2>

<p>Projede 2 controller bulunmaktadır. Aşağıda iki controller ile ilgili gönderilen istek ve karşılıklarını inceleyebilirsiniz.</p>
<p>
### Genel Endpoint Yapısı

End point inceleyin:

    http://localhost:8084/api/{controller}/{action}?[filters]&[find]&[limit]&[...]


Özellikler:

1. Tüm endpointler, controller yazıldıktan sonra `/api/` çağrısı ile devam eder.
2. `{controller}`çağrısı backend içerisinde bulunan controller sınıfının çoğul(s) adıdır. örneğin `customers` veya `loan-results`.
3. `{action}` controller sınıfına verilen metotlardır. Örneğin `{nationalId}` metodu ile T.C numarası parametre verilir ve müşteri bilgileri getirilir.
4. `[filters]` çeşitli filtreler ile GET sorgusu yapılabilir. Örneğin parametre olarak doğum tarihi ve T.C numarası verilip kredi sonucu öğrenilebilir.


### Customer Endpoint

Müşteri sınıfı ile ilgili tüm endpointler ve açıklamalar.

| Method   | URL                                      | Açıklama                              |
| -------- | ---------------------------------------- | ---------------------------------------- |
| `GET`    | `/api/customers`                             | Tüm müşterileri geri döner.                      |
| `POST`   | `/api/customers`                             | Yeni bir müşteri oluşturur. Yalnızca müşteri oluşturur.                      |
| `GET`    | `/api/customers/12341324123`                          | T.C Kimlik numarası #12341324123 olan müşteri sistemde varsa bilgilerini getirir.                       |
| `PUT`  | `/api/customers/12341324123`                          | T.C Kimlik numarası #12341324123 olan müşteri sistemde varsa bilgilerini günceller.                |
| `DELETE` | `/api/customers/12341324123`  | Kimlik numarası #12341324123 olan müşteri sistemde varsa bilgilerini siler.                     |
| `GET`    | `/api/users?active=true&sort=username&direction=asc&search=nodes` | Search for "nodes" in active users, sorted  by username ascendingly. |



### Loan-Result Endpoint

Kredi-Başvuru sınıfı ile ilgili tüm endpointler ve açıklamalar.

| Method   | URL                                      | Açıklama                              |
| -------- | ---------------------------------------- | ---------------------------------------- |
| `POST`    | `/api/loan-request/new-customer`                             | Yeni müşteri bilgileri alır ve önce bu müşteriyi sisteme kaydeder. Daha sonra kredi başvurusu yapıp sonucunu geriye döner.                      |
| `POST`   | `/api/loan-request/12341324123`                             | T.C Kimlik numarası #12341324123 olan müşteri sistemde varsa bu müşteriye ait bilgileri kullanarak kredi sonucu hesaplar.                      |
| `GET`    | `/api/loan-request/q?nationalId=12341324123&dateOfBirth=1990-02-28` | T.C Kimlik numarası #12341324123  ve doğum tarihi #28 Şubat 1990 olan müşteri sistemde varsa kredi sonucunu getirir. Burada doğum tarihi YYYY-MM-DD standartlarında yazılmalıdır. |



#### Swagger ile İşlem

Yukarıdaki endpoinleri swagger aracılığı ile test edebilirsiniz. `https://localhost:8084/swagger-ui.html`


</p>


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- ROADMAP -->
<h2 id="swagger"> :dart: Swagger Dokümantasyon Ekran Görüntüsü</h2>

<p align="justify"> 
 Swagger ile tüm backend api testlerini gerçekleştirebilirsiniz. İlgili dokümantasyona ulaşmak için proje yolu:

    http://localhost:8084/swagger-ui.html

<p align="center">
  <img src="docs/images/3.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

<p align="center">
  <img src="docs/images/4.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

<p align="center">
  <img src="docs/images/5.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

<p align="center">
  <img src="docs/images/6.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

<p align="center">
  <img src="docs/images/7.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

<p align="center">
  <img src="docs/images/8.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

</p>


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- ROADMAP -->
<h2 id="front"> :dart: Frontend Ekran Görüntüsü</h2>

<p align="justify"> 
Projenin belirli frontend kısımları React ile yazılmıştır. Docker ile çalışıyorsanız frontend adresi:

    http://localhost:9090/

Eğer npm ile kendiniz derleyip çalıştırıyorsanız frontend adresi:

    http://localhost:3000/

Örnek ekran görüntüleri

<p align="center">
  <img src="docs/images/1.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

<p align="center">
  <img src="docs/images/2.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

</p>


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- ROADMAP -->
<h2 id="front"> :dart: Docker İmajları Ekran Görüntüsü</h2>

<p align="justify"> 
Proje yolunda docker-compose.yml dosyasını build ettiğinizde 3 imaj çalışmaktadır. Sırasyıla; mongoDb, frontend projesi ve backend projesidir.


<p align="center">
  <img src="docs/images/9.png" alt="Table 3 and 4" width="75%" height="75%">
</p><br/>

</p>


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<!-- CONTRIBUTORS -->
<h2 id="contributors"> :scroll: Geliştirme</h2>

<p>
  :mortar_board: <i>Proje n11 ve Patika iş birliği ile geliştirilen 143. n11 TalentHub Java Bootcamp için hazırlanmıştır. <a href="https://www.patika.dev/bootcamp/n11-bootcampleri">Patika İlan Link</a></i> <br> <br>

:woman: <b>Patika.dev</b> <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email: <a>info@patika.dev</a> <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Web: <a href="https://www.patika.dev/hakkimizda">https://www.patika.dev/hakkimizda</a> <br>

:woman: <b>n11 TalentHub</b> <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email: <a>talenthub@n11.com</a> <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Web: <a href="https://www.n11.com/genel/talenthub-2250603">TalentHub Hakkında</a> <br>

<br>

<h2 id="contributors"> :scroll: İletişim ve Bilgiler</h2>

✤ <a href="mailto:burak@yaztem.com">Mail</a> <br>
✤ <a href="https://linkedin.com/in/byofficial">LinkedIn</a> <br>
✤ <a href="https://github.com/byofficial">GitHub</a> <br>
✤ <a href="https://www.youtube.com/channel/UCS4zK06kG5KY4Wtl2C9m5bg">YouTube</a> <br>
✤ <a href="https://www.udemy.com/user/burak-yildiz-120/">Udemy</a> <br>
✤ <a href="https://bit.ly/py390">Python Projeler ve Popüler Kütüphaneler Kitabı</a> <br>