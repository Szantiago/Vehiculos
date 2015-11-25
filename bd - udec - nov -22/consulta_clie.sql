select c.nume_iden, c.prim_nomb, c.segu_nomb, c.prim_apel, c.segu_apel, t.num_tele, v.marc_vehi, 
v.mode_vehi, ven.nom_vend,  ci.nomb_muni, ci.nomb_dpto, f.fech_fact

from tabl_clie c, tabl_tele t, tabl_vehi v, tabl_vend ven, tabl_fact f, tabl_cons cons, tabl_muni ci

where c.cons_clie=f. cons_clie and c.cons_clie=t.cons_clie and f.cons_vend=ven.cons_vend 
and f.cons_cons=cons.cons_cons
;



 