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
    public partial class Form1 : Form
    {
        
        public Form1()
        {
            InitializeComponent();
        }
        private void button1_Click(object sender, EventArgs e) //başla butonunu oluşturuyoruz
        {
            this.Hide(); //butona tıkladığımız zaman form1 gizletiliyor
            Form2 f2 = new Form2(); //yeni bir form, Form2 oluşturuluyor
            f2.ShowDialog();
            this.Close(); //Form 1 kapanıyor

        }
    }
}
