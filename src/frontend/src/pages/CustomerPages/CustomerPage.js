import React from 'react';
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
  <div className="footer-wrapper">
    <div className="footer-section f-section-1">
      <p className>
        Copyright © 2021{" "}
        <a target="_blank" href="https://designreset.com">
          DesignReset
        </a>
        , All rights reserved.
      </p>
    </div>
    <div className="footer-section f-section-2">
      <p className>
        Coded with{" "}
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width={24}
          height={24}
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          strokeWidth={2}
          strokeLinecap="round"
          strokeLinejoin="round"
          className="feather feather-heart"
        >
          <path d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z" />
        </svg>
      </p>
    </div>
  </div>
</div>;
}
