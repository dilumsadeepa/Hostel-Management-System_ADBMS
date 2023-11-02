import React, {useContext, useEffect, useState} from 'react'
import { Formik, Form, Field, ErrorMessage } from "formik";  //use for form handling
import Apiurl from '../ApiURL';
import * as Yup from "yup";   //use for validation purposes
import axios from 'axios';  
import { useNavigate } from 'react-router-dom' ;
import { Html5QrcodeScanner } from 'html5-qrcode';


const CreateNewComplaint = () => {

    // ---------QR Code Scan Part Start --------------------
    const [scanResult, setScanResult] = useState(null);
    const [manualSerialNumber, setManualSerialNumber] = useState('');
  
    useEffect(() => {
      const scanner = new Html5QrcodeScanner('reader', {
        qrbox: {
          width: 250,
          height: 250,
        },
        fps: 5,
      });
  
      let isScanning = true;
  
      scanner.render(success, error);
  
      function success(result) {
        if (isScanning) {
          scanner.clear();
          setScanResult(result);
          isScanning = false; // Set isScanning to false to stop further scanning
        }
      }
  
      function error(err) {
        console.warn(err);
      }
    }, []);
  
    function handleManualSerialNumberChange(event) {
      setManualSerialNumber(event.target.value);
    }

    // ---------QR Code Scan Part End--------------------

    let navigate = useNavigate();
    const initialValues = {
        userId: '',
        userIndex: '',
        complaint: '',
        resId: '',
        complaintDate: '',
        evidenceImage: '',
        status: ''
    };

    const onSubmit = (data) => {
        console.log(data);
        axios.post(`${Apiurl}/complaint/add`, data)
            .then((response) => { 
            navigate("/");   //return to  root page after creating new post
        });
    };


      // Validation rules defined here:
  const validationSchema = Yup.object().shape({
    cunit: Yup.string().required('You must provide a course code'),
    cdate: Yup.string().required('You must provide a course date'),
    ctime: Yup.string().required('You must provide a course time'),
    hall: Yup.string().required('You must provide a hall number'),
  });

    return (
        <div>

<h1>QR Scanning Code</h1>
      {scanResult ? (
        <div>
          <p>Success: <a href={scanResult}>{scanResult}</a></p>
          <p>Serial Number: {scanResult.slice(-16)}</p>
        </div>
      ) : (
        <div>
          <div id="reader"></div>
          <p className="center-text">Or enter the serial number manually:</p>
          <div className="center-input">
            <input
              type="text"
              value={manualSerialNumber}
              onChange={handleManualSerialNumberChange}
            />
            {manualSerialNumber && (
              <p>Serial Number: {manualSerialNumber.slice(-16)}</p>
            )}
          </div>
        </div>
      )}
        <div className="d-flex justify-content-center">
        <div className="col-sm-10 debox px-5">
        <Formik initialValues={initialValues} onSubmit={onSubmit} validationSchema={validationSchema}>
             <Form className='formContainer'> 
             <div class="mb-3">
             <label className="my-2">user Id:</label>
                <ErrorMessage name='userId' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="inputCreatePost" className={`form-control`} name='userId' placeholder='User Id' autocomplete="off" />
             </div>


                <div class="mb-3">
                <label className="my-2">user Index:</label>
                <ErrorMessage name='userId' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="inputCreatePost" className={`form-control`} name='userId' placeholder='User Id' autocomplete="off" />
                </div>
                

                <div class="mb-3">
                <label className="my-2">Complaint:</label>
                <ErrorMessage name='complaint' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field as="textarea" id="complaint" name="complaint"  className={`form-control`}  placeholder="Your complaint"/>
                </div>
               

             <div class="mb-3">
                <label className="my-2">Resource Id:</label>
                <ErrorMessage name='resId' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="resId" name="resId" placeholder="Your complaint"/>
            </div>

            <div class="mb-3">   
                <label className="my-2">Complaint Date:</label>
                <ErrorMessage name='complaintDate' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field as="date" id="complaintDate" name="complaintDate" className={`form-control`}  placeholder="Your complaint"/>
             </div>

             <div class="mb-3">  
                <label className="my-2">Evidence Image</label>
                <ErrorMessage name='evidenceImage' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="evidenceImage" name="evidenceImage" className={`form-control`}  placeholder="Evidence Image"/>
            </div>

            <div class="mb-3">
                <label className="my-2">Status :</label>
                <ErrorMessage name='status' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="status" name="status" className={`form-control`}  placeholder="Status"/>
            </div>


                

                <button type='submit' className="btn btn-primary mt-5">Save</button>
                <a  className="btn btn-outline-danger ms-2 mt-5" href='/complaints'>
                  Cancel
                </a>
            </Form>
        </Formik>
        </div>
    </div>
        </div>
    );
};

export default CreateNewComplaint;