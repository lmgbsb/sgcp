function SaltaCampo (campo, prox, tammax, teclapres){
   var tecla = teclapres.keyCode;
   vr = campo.value;
   tam = vr.length;
   if (tecla != 0 && tecla != 10 && tecla != 24)
      if (tam == tammax)
          prox.focus();
}