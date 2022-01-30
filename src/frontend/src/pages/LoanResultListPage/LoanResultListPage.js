import React from "react";
import Footer from "../../component/Footer/Footer";

export default function LoanResultListPage() {
  return (
    <div id="content" className="main-content">
      <div className="layout-px-spacing">
        <div className="row layout-top-spacing">
          <div className="col-xl-12 col-lg-12 col-sm-12  layout-spacing">
            <div className="widget-content widget-content-area br-6">
            <div id="tableHover" className="col-lg-12 col-12 layout-spacing">
        <div className="statbox widget box box-shadow">
          <div className="widget-header">
            <div className="row">
              <div className="col-xl-12 col-md-12 col-sm-12 col-12">
                <h4>Hover Table</h4>
              </div>                 
            </div>
          </div>
          <div className="widget-content widget-content-area">
            <div className="table-responsive">
              <table className="table table-bordered table-hover mb-4">
                <thead>
                  <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Sale</th>
                    <th className="text-center">Status</th>
                    <th />
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Shaun Park</td>
                    <td>10/08/2020</td>
                    <td>320</td>
                    <td className="text-center"><span className="text-success">Complete</span></td>
                    <td className="text-center"><svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" className="feather feather-trash-2 icon"><polyline points="3 6 5 6 21 6" /><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2" /><line x1={10} y1={11} x2={10} y2={17} /><line x1={14} y1={11} x2={14} y2={17} /></svg></td>
                  </tr>
                  <tr>
                    <td> Alma Clarke</td>
                    <td>11/08/2020</td>
                    <td>420</td>
                    <td className="text-center"><span className="text-secondary">Pending</span></td>
                    <td className="text-center"><svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" className="feather feather-trash-2 icon"><polyline points="3 6 5 6 21 6" /><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2" /><line x1={10} y1={11} x2={10} y2={17} /><line x1={14} y1={11} x2={14} y2={17} /></svg></td>
                  </tr>
                  <tr>
                    <td>Xavier</td>
                    <td>12/08/2020</td>
                    <td>130</td>
                    <td className="text-center"><span className="text-info">In progress</span></td>
                    <td className="text-center"><svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" className="feather feather-trash-2 icon"><polyline points="3 6 5 6 21 6" /><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2" /><line x1={10} y1={11} x2={10} y2={17} /><line x1={14} y1={11} x2={14} y2={17} /></svg></td>
                  </tr>
                  <tr>
                    <td>Vincent Carpenter</td>
                    <td>13/08/2020</td>
                    <td>260</td>
                    <td className="text-center"><span className="text-danger">Canceled</span></td>
                    <td className="text-center"><svg xmlns="http://www.w3.org/2000/svg" width={24} height={24} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" className="feather feather-trash-2 icon"><polyline points="3 6 5 6 21 6" /><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2" /><line x1={10} y1={11} x2={10} y2={17} /><line x1={14} y1={11} x2={14} y2={17} /></svg></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div className="code-section-container">
              <button className="btn toggle-code-snippet"><span>Code</span></button>
              <div className="code-section text-left">
                <pre>&lt;div class="table-responsive"&gt;{"\n"}{"    "}&lt;table class="table table-bordered table-hover table-striped mb-4"&gt;{"\n"}{"        "}&lt;thead&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;th&gt;Name&lt;/th&gt;{"\n"}{"                "}&lt;th&gt;Date&lt;/th&gt;{"\n"}{"                "}&lt;th&gt;Sale&lt;/th&gt;{"\n"}{"                "}&lt;th class="text-center"&gt;Status&lt;/th&gt;{"\n"}{"                "}&lt;th&gt;&lt;/th&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"        "}&lt;/thead&gt;{"\n"}{"        "}&lt;tbody&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt;Shaun Park&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;10/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;320&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-success"&gt;Complete&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt; Alma Clarke&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;11/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;420&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-secondary"&gt;Pending&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt;Xavier&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;12/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;130&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-info"&gt;In progress&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"            "}&lt;tr&gt;{"\n"}{"                "}&lt;td&gt;Vincent Carpenter&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;13/08/2020&lt;/td&gt;{"\n"}{"                "}&lt;td&gt;260&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;span class="text-danger"&gt;Canceled&lt;/span&gt;&lt;/td&gt;{"\n"}{"                "}&lt;td class="text-center"&gt;&lt;svg&gt; ... &lt;/svg&gt;&lt;/td&gt;{"\n"}{"            "}&lt;/tr&gt;{"\n"}{"        "}&lt;/tbody&gt;{"\n"}{"    "}&lt;/table&gt;{"\n"}&lt;/div&gt;{"\n"}{"    "}</pre>
              </div>
            </div>
          </div>
        </div>
      </div>
            </div>
          </div>
        </div>
      </div>
      <Footer/>
    </div>
  );
}
