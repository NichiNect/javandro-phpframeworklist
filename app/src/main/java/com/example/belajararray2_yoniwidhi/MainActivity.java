package com.example.belajararray2_yoniwidhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvList;
    String[] namaFramework;
    int[] logoFramework;
    String[] deskripsiFramework;
    String title = "Belajar Array";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.namaFramework = new String[] {
                "Laravel", "CodeIgniter", "Symfony", "Yii Framework", "Zend Framework", "CakePHP", "Phalcon", "Lumen API"
        };
        this.logoFramework = new int[] {
                R.drawable.laravel, R.drawable.codeigniter, R.drawable.symfony, R.drawable.yii, R.drawable.zend, R.drawable.cakephp, R.drawable.phalcon, R.drawable.lumen
        };
        this.deskripsiFramework = new String[] {
                "Laravel adalah kerangka kerja aplikasi web berbasis PHP yang open source, menggunakan konsep Model-View-Controller (MVC). Laravel berada dibawah lisensi MIT, dengan menggunakan GitHub sebagai tempat berbagi kode. Laravel adalah salah satu framework yang terkenal di Indonesia. Fitur dari Framework ini sangatlah banyak dan ekosistem dari Laravel sangatlah lengkap. Dukungan Laravel juga sangat disupport baik dari pihak pengembangnya ataupun dari komunitas yang menyediakan berbagai package siap pakai didalamnya. Framework ini dibuat oleh Taylor Otwell. Laravel pertama rilis pada Juni 2011, dan telah mencapai versi 8.xx pada September 2020 lalu",
                "CodeIgniter merupakan aplikasi open source yang berupa kerangka kerja PHP dengan model MVC (Model, View, Controller) untuk membangun situs web dinamis dengan menggunakan PHP. CodeIgniter memudahkan pengembang web untuk membuat aplikasi web dengan cepat dan mudah dibandingkan dengan membuatnya dari awal. CodeIgniter dirilis pertama kali pada 28 Februari 2006. Kelebihan dari framework ini adalah ukurannya yang sangat kecil(kurang dari 5MB) sehingga sangat cocok untuk membangun sebuah aplikasi berskala kecil menengah. Selain itu performapada CodeIgniter sangatlah cepat, hal ini dikarenakan ukuran framework ini yang cenderung kecil. Dokumentasi CodeIgniter juga cukup mudah dipahami untuk pemula. Framework ini rilis pertama pada Februari 2006, dan sekarang masih mencapai versi 4.xx pada Februari 2020 lalu",
                "Tujuan kerangka kerja Symfony adalah untuk mempercepat pembuatan dan pemeliharaan aplikasi web dan mengganti tugas pengodean yang berulang. Symfony juga bertujuan untuk pembangunan aplikasi yang kuat dalam skala perusahaan, dan bertujuan untuk memberi pengembang kendali penuh atas konfigurasi: dari struktur direktori ke pustaka-pustaka asing, hampir semuanya dapat dikustomisasi. Agar sebanding dengan pedoman pengembangan perusahaan, Symfony dibundel dengan perkakas tambahan untuk membantu pengembang melakukan pengujian, pengawakutuan, dan pendokumentasian proyek. Symfony begitu terinspirasi oleh Spring Framework.",
                "Yii adalah framework (kerangka kerja) PHP berbasis-komponen, berkinerja tinggi untuk pengembangan aplikasi Web berskala-besar. Yii menyediakan reusability maksimum dalam pemrograman Web dan mampu meningkatkan kecepatan pengembangan secara signifikan. Nama Yii (dieja sebagai /i:/) singkatan dari \"Yes It Is!\". Yii adalah framework pemrograman umum Web yang bisa dipakai untuk mengembangkan semua jenis aplikasi Web. Dikarenakan sangat ringan dan dilengkapi dengan mekanisme caching yang canggih, Yii sangat cocok untuk pengembangan aplikasi dengan lalu lintas-tinggi, seperti portal, forum, sistem manajemen konten (CMS), sistem e-commerce, dan lain-lain. Seperti kebanyakan PHP framework, Yii adalah MVC (Model View Controller) framework. Yii didesain dengan hati-hati dari awal agar sesuai untuk pengembangan aplikasi Web secara serius. Yii bukan berasal dari produk pada beberapa proyek maupun konglomerasi pekerjaan pihak-ketiga. Yii adalah hasil dari pengalaman kaya para pembuat pada pengembangan aplikasi Web dan investigasi framework pemrograman Web dan aplikasi yang paling populer. \n\n Sumber : https://www.yiiframework.com/doc/guide/1.1/id/quickstart.what-is-yii",
                "Zend Framework (ZF) adalah open source, kerangka aplikasi web berorientasi objek yang diimplementasikan dalam PHP 7 dan dilisensikan di bawah Lisensi BSD Baru. Framework ini pada dasarnya adalah kumpulan paket profesional berbasis PHP. Struktur dan komponen dari zend framework bisa di bilang agak unik karena, setiap komponen telah dirancang dengan beberapa dependensi pada komponen lainnya, zend framework juga sangatlah fleksibel, dan arsitektur yang bisa ditambah sehingga memungkinkan pengembang untuk menggunakan komponen secara individual atau yang sering kita sebut dengan “Use-At-Will” desain. Zend Framework dibuat oleh Zend yang merupakan pengembangan engine PHP. Sayangnya Zend Framework sendiri kurang populer di Indonesia",
                "CakePHP merupakan sebuah rapid development framework yang gratis dan open source untuk PHP. CakePHP adalah sebuah framework atau kerangka kerja untuk membuat aplikasi CRUD (Create, Read, Update, Delete) berbasis bahasa pemrograman PHP. CakePHP juga menjadi salah satu framework pilihan yang memungkinkan seorang dpengembang web untuk membuat sebuah aplikasi dengan karakter pengembangan RAD (Rapid Application Development), yang memungkinkan untuk digunakan dan dikembangkan menjadi aplikasi lain yang lebih kompleks. CakePHP menyediakan semua alat bantu yang diperlukan untuk memulai tugas coding yang perlu diselesaikan: yaitu logika aplikasi. Daripada membuat sesuatu yang baru setiap memulai proyek baru, pengguna dapat meninjau unduhan CakePHP dan mulai fokus kepada logik aplikasi yang hendak dibangun. ",
                "Phalcon merupakan framework PHP paling cepat saat ini. Kecepatan eksekusi programnya mengalahkan beberapa framework terkenal. Phalcon juga sempat menjadi perbincangan menarik di salah satu forum PHP Indonesia. Diawali dari thread salah satu anggota yang membagikan hasil survey Popular PHP Framework oleh SitePoint (http://www.sitepoint.com/best-php-frameworks-2014). Project Phalcon sendiri sebenarnya sudah dimulai sejak 2012, kemudian baru meraih stable release  tidak lama ini tepatnya pada 6 June 2014. Framework ini ditulis dalam bahasa C, C++, dan PHP. Phalcon juga menggunakan pola MVC seperti halnya framework popular lainnya seperti Cake, Codeigniter, Yii, Laravel, dll. Catatan penting yang harus kita tahu, ternyata wujud Phalcon adalah PHP C-Extension. Phalcon tidak ditulis dalam plain PHP. Anda tidak akan menemukan folder berisi file .php seperti halnya framework lain. Contoh extension sendiri seperti yang biasa kita gunakan BCMath, Ctype, FTP, MySQL, ODBC, Overload, PCRE, Session dan Curl.  Jika sudah terpasang, kita dapat memanggil fungsi tersebut langsung di source code php. Phalcon dibungkus dalam ekstensi C, bertujuan untuk menangani lebih banyak request. Jika ditulis dalam C maka kecepatan eksekusi program akan lebih cepat dan penggunaan resource juga berkurang. Phalcon sendiri sebenarnya dibuat untuk menangani Request yang besar. Namun sayangnya framework ini jarang dipakai di Indonesia",
                "Lumen adalah Micro Framework yang diciptakan pengembang Laravel untuk mengakomodasi kebutuhan developer yang ingin membuat aplikasi dalam skala lebih kecil dari Laravel. Karena banyak library yang dihilangkan dalam bundle source code, Lumen bisa dijadikan framework untuk membuat REST API. Lumen sebenarnya memang didesain untuk pembuatan Rest API, Ada beberapa Micro Framework lain yang dikhususkan untuk membuat REST API pada PHP seperti Slim Framework, Silex dll tentu dengan keistimewaanya masing-masing, namun yang menarik adalah Lumen dalam lamannya mampu menghandle hingga 1900 request per second! Lumen sudah dibundle dengan Eloquent ORM agar proses pengqueryan lebih mudah dan tidak memakan waktu karena kita tidak perlu lagi mengetik query yang panjang dan sederet fitur lain seperti Caching, Queues, Validation, Routing, Middleware dan powerful Laravel service container, dan lain-lain. Akan tetapi banyak programmer-programmer jaman sekarang yang lebih memilih untuk menggunakan Laravel langsung daripada Lumen karena support system Lumen yang relatif kurang baik dibandingkan dengan Laravel. \n\n Sumber: https://www.codepolitan.com/pengenalan-lumen-framework-micro-framework-berbasis-php-59f19fe6ea010#:~:text=Lumen%20adalah%20Micro%20Framework%20yang,framework%20untuk%20membuat%20REST%20API."
        };

        this.lvList = findViewById(R.id.lv_list);
        this.sessionManager = new SessionManager(getApplicationContext());

        if (this.sessionManager.getLogin() == false) {
            startActivity(new Intent(getApplicationContext(), LoginAct.class));
        }

        showAdapter();

        this.lvList.setOnItemClickListener(this);
    }

    public void showAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_item, R.id.tv_list_nama,  namaFramework);
        lvList.setAdapter(arrayAdapter);
    }

    public void showGambarAdapter() {
        GambarAdapter gambarAdapter = new GambarAdapter(getApplicationContext(), this.logoFramework);
        lvList.setAdapter(gambarAdapter);
    }

    public void showCardAdapter() {
        CardAdapter cardAdapter = new CardAdapter(getApplicationContext(), this.namaFramework, this.logoFramework, this.deskripsiFramework);
        lvList.setAdapter(cardAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        String getNamaFramework = this.namaFramework[i];
        String getDescFramework = this.deskripsiFramework[i];
        int getLogoFramework = this.logoFramework[i];

        Intent intent = new Intent(MainActivity.this, DeskripsiLengkap.class);
        intent.putExtra(DeskripsiLengkap.NAMA_FRAMEWORK, getNamaFramework);
        intent.putExtra(DeskripsiLengkap.DESC_FRAMEWORK, getDescFramework);
        intent.putExtra(DeskripsiLengkap.LOGO_FRAMEWORK, getLogoFramework);
        startActivity(intent);

        Toast.makeText(this, "Memilih " + getNamaFramework, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu m) {
//        m.findItem(R.id.option2).setEnabled(false);
        if(this.sessionManager.getLogin() == false) {
            m.findItem(R.id.option1).setEnabled(false);
            m.findItem(R.id.option2).setEnabled(false);
            m.findItem(R.id.option3).setEnabled(false);
            m.findItem(R.id.btn_logout).setVisible(false);
        }
        m.findItem(R.id.btn_logout).setTitle("Logout (" + this.sessionManager.getUsername() + ")");
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.option1:
                this.title = "Array Adapter - Yoni Widhi";
                showAdapter();
                break;
            case R.id.option2:
                this.title = "Gambar Adapter - Yoni Widhi";
                showGambarAdapter();
                break;
            case R.id.option3:
                this.title = "Card Adapter - Yoni Widhi";
                showCardAdapter();
                break;
            case R.id.option4:
                Intent i = new Intent(MainActivity.this, AboutMe.class);
                startActivity(i);
                break;
            case R.id.btn_logout:
                sessionManager.setLogin(false);
                sessionManager.setUsername("");
                startActivity(new Intent(getApplicationContext(), LoginAct.class));
        }
        setActionBarTitle(this.title);
        return true;
    }

    private void setActionBarTitle(String judul) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(judul);
        }
    }

}