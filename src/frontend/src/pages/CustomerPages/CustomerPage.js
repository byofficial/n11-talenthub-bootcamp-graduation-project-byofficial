import React from 'react';
import Footer from '../../component/Footer/Footer';
import CustomerList from './CustomerList';





export default function CustomerPage() {



  return    <div id="content" className="main-content">
  <div className="layout-px-spacing">
    <div className="row layout-top-spacing">
      <div className="col-xl-12 col-lg-12 col-sm-12  layout-spacing">
        <div className="widget-content widget-content-area br-6">
        <div id="tableHover" className="col-lg-12 col-12 layout-spacing">
    <div className="statbox widget box box-shadow">
      <div className="widget-header">
        <div className="row">
          <div className="col-xl-12 col-md-12 col-sm-12 col-12">
            <h4>Tüm Müşteriler</h4>
          </div>                 
        </div>
      </div>
      <div className="widget-content widget-content-area">
       <CustomerList/>
       
      
      </div>
    </div>
  </div>
        </div>
      </div>
    </div>
  </div>
  <Footer/>
</div>;
}
