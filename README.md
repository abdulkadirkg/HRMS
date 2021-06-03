# HRMS
<p align="center">
  <img width="200" src="https://user-images.githubusercontent.com/51646136/120723372-44bbb900-c4da-11eb-8c94-a32c0dc68961.png"/>
  <h1 align="center">Human Resources Management System</h1>
  <p float="left">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white"/>
  <img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB"/>
  </p>
</p>

<b><h2>İsterler</h2></b>
<ul>
  <li>
    
    Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.
    Kabul Kriterleri:
    Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
    Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
    Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
    Doğrulama geçerli değilse kullanıcı bilgilendirilir.
    Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
    Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.
    
    ✅ Tamamlandı
  </li>
   <li>
    
    Req 2 : İş verenler sisteme kayıt olabilmelidir.
    Kabul Kriterleri:
    Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, 
    şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
    Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
    Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. 
    HRMS personelinin (bizim :)) onayı gerekmektedir.
    Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
    
    ✅ Tamamlandı
  </li>
     <li>
  
    Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect.
    Kabul Kriterleri:
    Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.
    
    ✅ Tamamlandı
  </li>
     <li>
  
    Req 4 : İş verenler listelenebilmelidir. (Sadece tüm liste)
    
    ✅ Tamamlandı
  </li>
     <li>
  
    Req 5 : İş arayanlar listelenebilmelidir. (Sadece tüm liste)

    ✅ Tamamlandı
  </li>
    <li>
  
    Req 6 : İş pozisyonları listelenebilmelidir. (Sadece tüm liste)

    ✅ Tamamlandı
  </li>
      <li>
  
    Req 7 : İş verenler sisteme iş ilanı ekleyebilmelidir.
    İş ilanı formunda;
    Seçilebilir listeden (dropdown) genel iş pozisyonu seçilebilmelidir.(Örneğin Java Developer)(Zorunlu)
    İş tanımı girişi yapılabilmelidir. (Örneğin; firmamız için JAVA, C# vb. dillere hakim....)(Zorunlu)
    Şehir bilgisi açılır listeden seçilebilmelidir. (Zorunlu)
    Maaş skalası için min-max girişi yapılabilmelidir. (Opsiyonel)
    Açık pozisyon adedi girişi yapılabilmelidir. (Zorunlu)
    Son başvuru tarihi girişi yapılabilmelidir.

    ✅ Tamamlandı
  </li>
      <li>
  
    Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.
    Liste, tablo formunda gelmelidir.
    Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

    ✅ Tamamlandı
  </li>
      <li>
  
    Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.
    Liste, tablo formunda gelmelidir.
    Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

    ✅ Tamamlandı
  </li>
      <li>
  
    Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.
    Liste, tablo formunda gelmelidir.
    Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.
    
    ✅ Tamamlandı
  </li>
        <li>
  
    Req 11 : İş verenler sistemdeki bir ilanı kapatabilmelidir. (Pasif ilan)
    
    ✅ Tamamlandı
  </li>
          <li>
  
    Req 12: Adaylar sisteme CV girişi yapabilmelidir.
    Adaylar okudukları okulları sisteme ekleyebilmelidir. (Okul adı, bölüm)
    Bu okullarda hangi yıllarda okuduklarını sisteme girebilmelidir.
    Eğer mezun değilse mezuniyet yılı boş geçilebilmelidir.
    Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir. Mezun olunmamışsa yine bu okul en üstte 
    ve "devam ediyor" olarak görüntülenmelidir.
    Adaylar iş tecübelerini girebilmelidir. (İş yeri adı, pozisyon)
    Bu tecrübelerini hangi yıllarda yaptıklarını sisteme girebilmelidir.
    Eğer hala çalışıyorsa işten ayrılma yılı boş geçilebilmelidir.
    Adayların tecrübeleri yıla göre tersten sıralanabilmelidir. Hala çalışıyorsa yine bu tecrübesi en üstte ve 
    "devam ediyor" olarak görüntülenmelidir.
    Adaylar bildikleri yabancı dilleri sisteme girebilmelidir. ( Dil, Seviye -> 1-5)
    Adaylar sisteme fotoğraf girebilmelidir. Adaya ait fotoğraf https://cloudinary.com/pricing sisteminde tutulacaktır. 
    (Dış servis entegrasyonu) Ücretsiz hesabı kullanınız.
    Adaylar sisteme github adreslerini girebilmelidir.
    Adaylar sisteme linkedin adreslerini girebilmelidir.
    Adaylar bildikleri programlama dillerini veya teknolojilerini sisteme girebilmelidir. 
    (Programlama/Teknoloji adı) Örneğin; React
    Adaylar sisteme ön yazı ekleyebilmelidir. (Örneğin: Çalışmayı çok severim....)
    
    ☝ Çalışılıyor...
  </li>
   <li>
  
    Req 13 : Bir adaya ait tüm CV bilgisi görüntülenebilmelidir.

    ☝ Çalışılıyor...
  </li>
</ul>

<p align="center">Made With ♥</p>

