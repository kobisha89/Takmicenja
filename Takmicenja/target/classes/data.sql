
INSERT INTO format (id, broj_ucesnika, tip)
              VALUES (1, 20,'Grand Slam');
              INSERT INTO format (id, broj_ucesnika, tip)
              VALUES (2, 15,'Masters 1000');
              INSERT INTO format (id, broj_ucesnika, tip)
              VALUES (3, 20,'Masters 500');
              
              INSERT INTO takmicenje (id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id)
              VALUES (1, '2020-11-10','2020-11-11','Pariz', 'Turnir1', 1);
              INSERT INTO takmicenje (id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id)
              VALUES (2, '2020-08-10','2020-08-11','London', 'Turnir2', 2);
              INSERT INTO takmicenje (id, datum_pocetka, datum_zavrsetka, mesto_odrzavanja, naziv, format_id)
              VALUES (3, '2020-06-10','2020-07-11','Rim', 'Turnir3', 3);
              
              INSERT INTO prijava (id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id)
              VALUES (1, '2020-01-10','Srbija', 'prvi@email.com', 1);
              INSERT INTO prijava (id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id)
              VALUES (2, '2020-02-10','Rusija', 'drugi@email.com', 2);
              INSERT INTO prijava (id, datum_prijave, drzava_takmicara, kontakt, takmicenje_id)
              VALUES (3, '2020-03-10','Grcka', 'treci@email.com', 3);

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');