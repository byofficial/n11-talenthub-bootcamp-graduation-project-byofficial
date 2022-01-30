import React, { useState } from "react";

export default function LoanList() {
  const [error, setError] = useStatete(null);
  const [isLoading, setIsLoading] = useState(false);
  const [customerList, setCustomerList] = useState([]);

  useEffect(() => {
      fetch("http://localhost:8504//api/customers")
  }, [])


  return <div></div>;
}
