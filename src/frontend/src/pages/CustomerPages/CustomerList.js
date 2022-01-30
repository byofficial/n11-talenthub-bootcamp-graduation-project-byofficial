import React, { useEffect, useState } from "react";
import { API_BASE_URL } from "../../constants";

export default function CustomerList() {
  const [error, setError] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [customerList, setCustomerList] = useState([]);

 const getCustomerList =  useEffect(() => {
    fetch(API_BASE_URL + "/customers")
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoading(true);
          setCustomerList(result);
      
        },
        (error) => {
          setIsLoading(true);
          setError(error);
 
        }
      );
  }, []);

  
  if (error) {
    return <div></div>;
  } else if (!isLoading) {
    return <div>Yükleniyor...</div>;
  } else {
    return (
      <div>
      <div className="table-responsive">
        <table className="table table-bordered table-hover mb-4">
          <thead>
            <tr>
              <th>T.C No</th>
              <th>Ad</th>
              <th>Soyad</th>
              <th>Telefon</th>
              <th>Aylık Gelir</th>
              <th>Doğum Tarihi</th>
              <th>Kayıt Tarihi</th>
              <th>İşlemler</th>
        
            </tr>
          </thead>
          <tbody>
            {customerList.map((customer) => (
              <tr>
                <td>{customer.nationalIdNumber}</td>
                <td>{customer.firstName}</td>
                <td>{customer.lastName}</td>
                <td>{customer.phoneNumber}</td>
                <td>{customer.monthlyIncome}</td>
                <td>{customer.dateOfBirth}</td>
                <td>{customer.createdDate}</td>
                <td>  <ul className="table-controls">
      
        <li><a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="Güncelle"><svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" className="feather feather-edit-2 text-success"><path d="M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z" /></svg></a></li>
        <li><a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="Sil"><svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" className="feather feather-trash-2 text-danger"><polyline points="3 6 5 6 21 6" /><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2" /><line x1={10} y1={11} x2={10} y2={17} /><line x1={14} y1={11} x2={14} y2={17} /></svg></a></li>
      </ul></td>
              </tr>
            ))}
          </tbody>
        </table>

      </div>
      <div className="code-section-container">
          <button className="btn toggle-code-snippet" onClick={getCustomerList}><span>Yenile</span></button>
          <div className="code-section text-left">
            <pre>&lt;div class="table-responsive"&gt;{"\n"}{"    "}&lt;table class="table table-bordered table-hover table-striped mb-4"&gt;{"\n"}{"        "}&lt;thead&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;th&gt;Name&lt;/th&gt;{"\n"}{"                "}&lt;th&gt;Date&lt;/th&gt;{"\n"}{"                "}&lt;th&gt;Sale&lt;/th&gt;{"\n"}{"                "}&lt;th class="text-center"&gt;Status&lt;/th&gt;{"\n"}{"                "}&lt;th&gt;&lt;/th&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"        "}&lt;/thead&gt;{"\n"}{"        "}&lt;tbody&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt;Shaun Park&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;10/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;320&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-success"&gt;Complete&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt; Alma Clarke&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;11/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;420&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-secondary"&gt;Pending&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt;Xavier&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;12/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;130&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-info"&gt;In progress&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt;Vincent Carpenter&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;13/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;260&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-danger"&gt;Canceled&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"        "}&lt;/tbody&gt;{"\n"}{"    "}&lt;/table&gt;{"\n"}&lt;/div&gt;{"\n"}{"    "}</pre>
          </div>
        </div>
      </div>
    );
  }
}
