import {
    createContext,
    useContext,
    useState,
    useEffect,
  } from "react";
  import { privateAPi } from "../services/privateApi";
  import { setUserLocalStorage } from "../context/AuthProvider/util";
  
  
  const AutorizacaoContext = createContext (
    undefined
  );
  
  
  export const AutorizacaoProvider = ({children}) => {
    const [isAuthenticated, setIsAuthenticated] = useState(true);
    const [userRole, setUserRole] = useState("");
  
    useEffect(() => {
      const validaToken = async () => {
        try {
          const response = await privateAPi.get("/validation");
          const { role } = response.data;
          setUserRole(role);
        } catch (error) {
          if (
            error.response &&
            (error.response.status === 401 || error.response.status === 403)
          ) {
            setUserLocalStorage(null);
            setIsAuthenticated(false);
          } else {
            console.error("Erro:", error);
          }
        }
      };
      validaToken();
    }, []);
  
    return (
      <AutorizacaoContext.Provider value={{ isAuthenticated, userRole }}>
        {children}
      </AutorizacaoContext.Provider>
    );
  };
  
  export const useAutorizacao = () => {
    const context = useContext(AutorizacaoContext);
    if (!context) {
      throw new Error("useAutorizacao must be used within a AutorizacaoProvider");
    }
    return context;
  };