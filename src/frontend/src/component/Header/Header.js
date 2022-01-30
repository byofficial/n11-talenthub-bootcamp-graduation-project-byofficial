import React from "react";

export default function Header() {
  return (
    <div>
      {/*  BEGIN NAVBAR  */}
      <div className="header-container fixed-top">
        <header className="header navbar navbar-expand-sm">
          <ul className="navbar-item theme-brand flex-row  text-center">
            <li className="nav-item theme-logo">
              <a href="index.html">
                <img
                  src="assets/img/n11.png"
                  className="navbar-logo"
                  alt="logo"
                />
              </a>
            </li>
            <li className="nav-item theme-text">
              <a href="index.html" className="nav-link">
                {" "}
                N11 API PROJECT{" "}
              </a>
            </li>
          </ul>

        </header>
      </div>
      {/*  END NAVBAR  */}
      {/*  BEGIN NAVBAR  */}
      <div className="sub-header-container">
        <header className="header navbar navbar-expand-sm">
          <a
            href="javascript:void(0);"
            className="sidebarCollapse"
            data-placement="bottom"
          >
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
              className="feather feather-menu"
            >
              <line x1={3} y1={12} x2={21} y2={12} />
              <line x1={3} y1={6} x2={21} y2={6} />
              <line x1={3} y1={18} x2={21} y2={18} />
            </svg>
          </a>
          <ul className="navbar-nav flex-row">
            <li>
              <div className="page-header">
                <div className="page-title">
                  <h3>| Burak YILDIZ</h3>
                </div>
              </div>
            </li>
          </ul>
        </header>
      </div>
      {/*  END NAVBAR  */}
    </div>
  );
}
