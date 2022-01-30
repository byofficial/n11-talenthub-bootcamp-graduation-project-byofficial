import React from "react";
import { Link } from "react-router-dom";

export default function Sidebar() {
  return (
    <div className="sidebar-wrapper sidebar-theme">
      <nav id="sidebar">
        <div className="shadow-bottom" />
        <ul className="list-unstyled menu-categories" id="accordionExample">

        <li class="menu">
            <Link
              ariaExpanded="false"
              className="dropdown-toggle"
              to="/"
            >
              <div class="">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  class="feather feather-book"
                >
                  <path d="M4 19.5A2.5 2.5 0 0 1 6.5 17H20"></path>
                  <path d="M6.5 2H20v20H6.5A2.5 2.5 0 0 1 4 19.5v-15A2.5 2.5 0 0 1 6.5 2z"></path>
                </svg>
                <span>Ana Sayfa</span>
              </div>
            </Link>
          </li>


          <li className="menu">
            <a
              href="#submenu"
              data-toggle="collapse"
              aria-expanded="false"
              className="dropdown-toggle"
            >
              <div className>
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
                  className="feather feather-airplay"
                >
                  <path d="M5 17H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-1" />
                  <polygon points="12 15 17 21 7 21 12 15" />
                </svg>
                <span> Müşteri İşlemleri</span>
              </div>
              <div>
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
                  className="feather feather-chevron-right"
                >
                  <polyline points="9 18 15 12 9 6" />
                </svg>
              </div>
            </a>
            <ul
              className="collapse submenu list-unstyled"
              id="submenu"
              data-parent="#accordionExample"
            >
              <li>
                <Link to="/customers"> Tüm Müşteriler</Link>
              </li>
              <li>
                <Link to="/customers/req"> Müşteri Sorgula</Link>
              </li>

              <li>
                <Link to="/customers/register"> Müşteri Ekle</Link>
              </li>

              <li>
                <Link to="/customers"> Müşteri Sil</Link>
              </li>

              <li>
                <Link to="/customers"> Müşteri Güncelle</Link>
              </li>
            </ul>
          </li>

          <li className="menu">
            <a
              href="#submenu2"
              data-toggle="collapse"
              aria-expanded="false"
              className="dropdown-toggle"
            >
              <div className>
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
                  className="feather feather-file"
                >
                  <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z" />
                  <polyline points="13 2 13 9 20 9" />
                </svg>
                <span> Kredi İşlemleri</span>
              </div>
              <div>
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
                  className="feather feather-chevron-right"
                >
                  <polyline points="9 18 15 12 9 6" />
                </svg>
              </div>
            </a>
            <ul
              className="collapse submenu list-unstyled"
              id="submenu2"
              data-parent="#accordionExample"
            >
              <li>
                <Link to="/loan-result"> Tüm Krediler</Link>
              </li>

              <li>
                <Link to="/loan-result/new-credit"> Kredi Ekle</Link>
              </li>

              <li>
                <Link to="/loan-result/new-customer-credit"> Kredi & Müşteri Ekle</Link>
              </li>
            </ul>
          </li>

          <li class="menu">
            <Link
              ariaExpanded="false"
              className="dropdown-toggle"
              to="/loan-result/req"
            >
              <div class="">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  class="feather feather-book"
                >
                  <path d="M4 19.5A2.5 2.5 0 0 1 6.5 17H20"></path>
                  <path d="M6.5 2H20v20H6.5A2.5 2.5 0 0 1 4 19.5v-15A2.5 2.5 0 0 1 6.5 2z"></path>
                </svg>
                <span>Kredi Sorgula</span>
              </div>
            </Link>
          </li>
        </ul>
      </nav>
    </div>
  );
}
