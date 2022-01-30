import React from "react";
import Footer from "../../component/Footer/Footer";

export default function HomePages() {
  return (
    <div id="content" className="main-content">
      <div className="layout-px-spacing">
        <div className="row layout-top-spacing">
          <div className="col-xl-12 col-lg-12 col-md-12 col-12 layout-spacing">
            <div className="widget widget-content-area br-4">
              <div className="widget-one">
                <h6>n11 Bitirme Projesi UI çalışması!</h6>
                <p className="mb-0 mt-3">
                  Müşteri Ekleme ve Tüm Müşteri Listesi bölümleri çalışmaktadır. Diğer Bölümlerin UI çalışması yapılmamıştır.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>

<Footer/>
    </div>
  );
}
