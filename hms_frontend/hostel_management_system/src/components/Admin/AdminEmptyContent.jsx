import React, { useEffect, useRef } from "react";
import AdminNavbar from "./AdminNavbar";
import AdminTopBar from "./AdminTopBar";
import AdminFooter from "./AdminFooter";
import DashboardTables from "./DashboardTables";

import axios from 'axios';

import 'jquery';
import $ from 'jquery';
import 'datatables.net-dt/css/jquery.dataTables.css';

const AdminEmptyContent = () => {
    const tableRef = useRef(null);

  useEffect(() => {
    // Function to fetch data from the API and initialize the DataTable
    const fetchDataAndInitializeTable = async () => {
      try {
        // Fetch data from the API
        const response = await axios.get('http://localhost:8080/res/all');
        const data = response.data;
        console.log(data);

        // Initialize the DataTable
        if (tableRef.current) {
          $(tableRef.current).DataTable({
            data: data,
            columns: [
              { data: 'resId' },
              { data: 'roomNo' },
              { data: 'resName' },
              { data: 'installationDate' },
              { data: 'lastMaintenanceDate' },
              { data: 'status' },
            ],
          });
        }
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    // Call the fetchDataAndInitializeTable function
    fetchDataAndInitializeTable();
  }, []);


  return (
    <div id="page-top">
      <div id="wrapper">
        <AdminNavbar />
        <div className="d-flex flex-column" id="content-wrapper">
          <div id="content">
            <AdminTopBar />
            <div className="container-fluid">
              <div className="d-sm-flex justify-content-between align-items-center mb-4">
                <h3 className="text-dark mb-0">Dashboard</h3>
                <a
                  className="btn btn-primary btn-sm d-none d-sm-inline-block"
                  role="button"
                  href="#"
                >
                  <i className="fas fa-download fa-sm text-white-50"></i>
                  &nbsp;New Complaint
                </a>
              </div>


              <h2>Your Resources Content Goes Here</h2>

              <table ref={tableRef} className="display" style={{ width: '100%' }}>
                <thead>
                    <tr>
                    <th>Resource ID</th>
                    <th>Room No</th>
                    <th>Resource Name</th>
                    <th>Installation Date</th>
                    <th>Last Maintenance Date</th>
                    <th>Status</th>
                    </tr>
                </thead>
                <tbody></tbody>
                </table>

                <DashboardTables />

              <AdminFooter />
            </div>
            <a
              className="border rounded d-inline scroll-to-top"
              href="#page-top"
            >
              <i className="fas fa-angle-up"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminEmptyContent;
