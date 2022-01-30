import React, { useState } from 'react';
import Footer from '../../component/Footer/Footer';
import { API_BASE_URL } from '../../constants';

export default function NewCustomer() {

    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(false);
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [monthlyIncome, setMonthlyIncome] = useState(0);
    const [guarantee, setGuarantee] = useState(0);
    const [nationalIdNumber, setNationalIdNumber] = useState("");
    const [dateOfBirth, setDateOfBirth] = useState(null);

    const saveCustomer = () => {
        fetch(API_BASE_URL + "/customers",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                phoneNumber: phoneNumber,
                monthlyIncome: monthlyIncome,
                guarantee: guarantee,
                nationalIdNumber: nationalIdNumber,
                dateOfBirth: dateOfBirth,
              }),
        })
        .then((res) => res.json())
        .catch((err) => console.log("Error"));
    }
    const handleSubmit = () => {
        saveCustomer();
console.log(firstName);
    }

    const handleFirstName = (value) => {
        setFirstName(value);
    }

    const handleLastName = (value) => {
        setLastName(value);
    }
    const handlePhoneNumber = (value) => {
        setPhoneNumber(value);
    }
    const handleMonthlyIncome = (value) => {
        setMonthlyIncome(value);
    }
    const handleGuarantee = (value) => {
        setGuarantee(value);
    }
    const handleNationalIdNumber = (value) => {
        setNationalIdNumber(value);
    }
    const handleDateOfBirth = (value) => {
        setDateOfBirth(value);
    }

  return (
  <div id="content" className="main-content">
  <div className="layout-px-spacing">
    <div className="row layout-top-spacing">
  <div className="col-xl-12 col-lg-12 col-md-12 layout-spacing">
  <form id="contact" className="section contact">
    <div className="info">
      <h5 className>Müşteri Ekle</h5>
      <div className="row">
        <div className="col-md-11 mx-auto">
          <div className="row">

          <div className="col-md-6">
              <div className="form-group">
                <label htmlFor="location">Müşteri Adı</label>
                <input type="text" className="form-control mb-4" id="location" placeholder="Müşteri Adı" onChange={(i) => handleFirstName(i.target.value)} />
              </div>
            </div>


            
          <div className="col-md-6">
              <div className="form-group">
                <label htmlFor="location">Müşteri Soyadı</label>
                <input type="text" className="form-control mb-4" id="location" placeholder="Müşteri Soyadı"  onChange={(i) => handleLastName(i.target.value)}/>
              </div>
            </div>

               
          <div className="col-md-6">
              <div className="form-group">
                <label htmlFor="location">T.C Kimlik Numarası</label>
                <input type="text" className="form-control mb-4" id="location" placeholder="2344xxxxxxx"  onChange={(i) => handleNationalIdNumber(i.target.value)}/>
              </div>
            </div>



            <div className="col-md-6">
              <div className="form-group">
                <label htmlFor="location">Müşteri Telefon</label>
                <input type="text" className="form-control mb-4" id="location" placeholder="0555xxxxxxx"  onChange={(i) => handlePhoneNumber(i.target.value)}/>
              </div>
            </div>

            <div className="col-md-6">
              <div className="form-group">
                <label htmlFor="location">Aylık Gelir</label>
                <input type="number" className="form-control mb-4" id="location" placeholder="Örn: 5000" onChange={(i) => handleMonthlyIncome(i.target.value)} />
              </div>
            </div>

            <div className="col-md-6">
              <div className="form-group">
                <label htmlFor="location">Teminat(Opsiyonel)</label>
                <input type="number" className="form-control mb-4" id="location" placeholder="Örn: 50000"  onChange={(i) => handleGuarantee(i.target.value)}/>
              </div>
            </div>

            <div className="col-md-6">
              <div className="form-group">
                <label htmlFor="location">Doğum Tarihi</label>
                <input type="date" className="form-control mb-4" id="location" placeholder="YYYY-MM-DD" onChange={(i) => handleDateOfBirth(i.target.value)} />
              </div>
            </div>


            <div className="col-md-6 mt-4">
       <div className="form-group">

          <button id="add-skills" className="btn btn-primary" onClick={handleSubmit}>Yeni Müşteri Kaydet</button>
        </div>
      </div>


           
          </div>
        </div>
      </div>
    </div>
  </form>
</div></div>

<Footer/>
</div></div>);
}
