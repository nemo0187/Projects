/****************************************************************************
**					SAKARYA ÜNİVERSİTESİ
**				BİLGİSAYAR VE BİLİŞİM BİLİMLERİ FAKÜLTESİ
**				    BİLGİSAYAR MÜHENDİSLİĞİ BÖLÜMÜ
**				   NESNEYE DAYALI PROGRAMLAMA DERSİ
**					2020-2021 BAHAR DÖNEMİ
**	
**				ÖDEV NUMARASI..........:Proje
**				ÖĞRENCİ ADI............:Fuad Garibli
**				ÖĞRENCİ NUMARASI.......:G201210558
**              DERSİN ALINDIĞI GRUP...:2C
****************************************************************************/
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proje
{
    public partial class Form2 : Form 
    {
        int counter;
        int rnd1;
        int puan;
        double vitamina;
        double vitaminc;
        int agirlik;
        string meyve;
        
        public Form2()
        {
            InitializeComponent();
        }

        private void vita1() //katı meyveler için oluşturuyoruz
        {
            double vitaA = Convert.ToDouble(label9.Text);
            double vitaC = Convert.ToDouble(label10.Text);
            double agirlik1 = Convert.ToDouble(label11.Text);
            if (rnd1 == 0) // randomdan çilek gelirse
            {
                Random agr = new Random();
                int meyveAgirlik = agr.Next(70,120); // meyve ağırlıklarının 70-120 gram arası gelmesini sağlıyoruz

                Random vrm = new Random();
                int verim = vrm.Next(30,70);

                 meyve = "Çilek";
                 vitamina = meyveAgirlik * 0.12; // vitamini orana uygun hesaplattırıyoruz
                 vitaminc = meyveAgirlik * 0.6;
                 agirlik = meyveAgirlik;
                label8.Text = "Ağırlık: " + agirlik + " gr";
                label2.Text = "Vitamin A: " + vitamina + " iu";
                label3.Text = "Vitamin C: " + vitaminc + " mg";
                label4.Text = "Meyve: " + meyve;
                button2.Enabled = false; //buton 2'yi tıklanılmaz ediyoruz
                button1.Enabled = true;


            }

            if (rnd1 == 1) //randomdan elma gelirse
            {
                Random agr = new Random();
                int meyveAgirlik = agr.Next(70, 120); 
                meyve = "Elma";
                vitamina = meyveAgirlik*0.54; 
                vitaminc = meyveAgirlik * 0.05;
                agirlik = meyveAgirlik;
                button2.Enabled = false;
                button1.Enabled = true;
                label8.Text = "Ağırlık: " + agirlik + " gr";
                label2.Text = "Vitamin A: " + vitamina + " iu";
                label3.Text = "Vitamin C: " + vitaminc + " mg";
                label4.Text = "Meyve: " + meyve;

            }

            if (rnd1 == 2) //randomdan armut gelirse
            {
                Random agr = new Random();
                int meyveAgirlik = agr.Next(70, 120);
                meyve = "Armut";
                vitamina = meyveAgirlik * 0.25;
                vitaminc = meyveAgirlik * 0.05;
                agirlik = meyveAgirlik;
                button2.Enabled = false;
                button1.Enabled = true;
                label8.Text = "Ağırlık: " + agirlik + " gr";
                label2.Text = "Vitamin A: " + vitamina + " iu";
                label3.Text = "Vitamin C: " + vitaminc + " mg";
                label4.Text = "Meyve: " + meyve;

               
            }
           
            label9.Text = Convert.ToString(vitaA + vitamina);
            label10.Text = Convert.ToString(vitaC + vitaminc);
            label11.Text = Convert.ToString(agirlik1 + agirlik);
        }

        private void vita2() //naringiye meyveler için oluşturuyoruz
        {
            double vitaA = Convert.ToDouble(label9.Text);
            double vitaC = Convert.ToDouble(label10.Text);
            double agirlik1 = Convert.ToDouble(label11.Text);
            if (rnd1 == 3) //randomdan mandalina gelirse
            {
                Random agr = new Random();
                int meyveAgirlik = agr.Next(70, 120);
                meyve = "Mandalina";
                vitamina = meyveAgirlik* 6.81;
                vitaminc = meyveAgirlik*0.26;
                agirlik = meyveAgirlik;
                button1.Enabled = false;
                button2.Enabled = true;
                label8.Text = "Ağırlık: " + agirlik + " gr";
                label2.Text = "Vitamin A: " + vitamina + " iu";
                label3.Text = "Vitamin C: " + vitaminc + " mg";
                label4.Text = "Meyve: " + meyve;


            }
            if (rnd1 == 4) //randomdan greyfrut gelirse
            {
                Random agr = new Random();
                int meyveAgirlik = agr.Next(70, 120);
                meyve = "Greyfurt";
                vitamina = meyveAgirlik*0.03;
                vitaminc = meyveAgirlik * 0.44;
                agirlik = meyveAgirlik;
                button1.Enabled = false;
                button2.Enabled = true;
                label8.Text = "Ağırlık: " + agirlik + " gr";
                label2.Text = "Vitamin A: " + vitamina + " iu";
                label3.Text = "Vitamin C: " + vitaminc + " mg";
                label4.Text = "Meyve: " + meyve;


            }
            if (rnd1 == 5) //randomdan portakal gelirse
            {
                Random agr = new Random();
                int meyveAgirlik = agr.Next(70, 120);
                meyve = "Portakal";
                vitamina = meyveAgirlik*2.25;
                vitaminc = meyveAgirlik*0.45;
                agirlik = meyveAgirlik;
                button1.Enabled = false;
                button2.Enabled = true;
                label8.Text = "Ağırlık: " + agirlik + " gr";
                label2.Text = "Vitamin A: " + vitamina + " iu";
                label3.Text = "Vitamin C: " + vitaminc + " mg";
                label4.Text = "Meyve: " + meyve;



            }
            
            label9.Text = Convert.ToString(vitaA + vitamina);
            label10.Text = Convert.ToString(vitaC + vitaminc);
            label11.Text = Convert.ToString(agirlik1 + agirlik);
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            timer1.Interval = 1000; //sayacın intervalını tanımlıyoruz
            timer1.Enabled = true;
            timer1.Start();
            counter = 60; //sayacı 60 saniyeye kuruyoruz

            Random rnd = new Random();
            rnd1 = rnd.Next(0, 5);
            pictureBox1.Image = imageList1.Images[rnd1]; //random rakamla ismine uygun meyveyi getirtiyoruz
            vita1();
            vita2();
            label9.Text = "0";
            label10.Text = "0";
            label11.Text = "0";
           
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            counter--;


            lblcounter.Text = "Sayaç  00:" + Convert.ToString(counter);

            if(counter == 0) //eğer sayaç "0" olursa, sayacı durduruyoruz
            {
                timer1.Stop();
                button1.Enabled = false; //gerisayım bittiğinde butonu basılmaz yapıyoruz
                button2.Enabled = false;
                panel1.Enabled = false;
                pictureBox1.Visible = false; //gerisayım bittiğinde pictureboxsa resim gelmemesini sağlıyoruz                                  
            }
        }
        
        
        private void button1_Click(object sender, EventArgs e) 
        {
            
            if (rnd1 == 0 || rnd1 == 1 || rnd1 == 2)
            {   
                puan += 1; 
            }
            if (rnd1 == 3 || rnd1 == 4 || rnd1 == 5)
            {
                puan -= 1;
            }
            Random rnd2 = new Random();
            rnd1 = rnd2.Next(0, 5);
            pictureBox1.Image = imageList1.Images[rnd1];
            label1.Text = Convert.ToString(puan);
            vita1();
            vita2();
        }

        private void button2_Click(object sender, EventArgs e)
        {

            if (rnd1 == 0 || rnd1 == 1 || rnd1 == 2)
            {

                puan -= 1;

            }
            if (rnd1 == 3 || rnd1 == 4 || rnd1 == 5)
            {


                puan += 1;

            }
            Random rnd3 = new Random();
            rnd1 = rnd3.Next(0, 5);
            pictureBox1.Image = imageList1.Images[rnd1];

            vita2();
            vita1();
            label1.Text = Convert.ToString(puan);


        }

        private void label11_Click(object sender, EventArgs e)
        {

        }
    }
}
