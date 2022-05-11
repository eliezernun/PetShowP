public class Login {
   private String[] usuario;
   private String[] senha;
   private Login(){      
   }
   public boolean setUser(String[] args){
      if(args.length > 4){
         this.usuario =  args;
         return true;
      }else{
         return false;
      }
   }
   public boolean setSenha(String[] args){
      if(args.length > 4){
         this.senha =  args;
         return true;
      }else{
         return false;
      }
   }

   public boolean setLogin(){
      return false;
   }


}
