import React, {useContext, useEffect, useState} from 'react'
import { Formik, Form, Field, ErrorMessage } from "formik";  //use for form handling
import Apiurl from '../Apiurl';
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


    return (
        <div>
            
        </div>
    );
};

export default CreateNewComplaint;