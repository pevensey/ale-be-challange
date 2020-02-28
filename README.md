# REST-API-ALE-BE

## General Info
REST API for absent, class scheduling and material sharing. This rest-api could perform GET, POST, PUT, and DELETE method.

## Specification
 
* JDK 1.8, 
* Spring Boot 2.0.1. RELEASE, 
* Maven 3.6.2,
* Maria DB 10.4.8.

### Endpoints
These endpoints tested on Postman v7.19.1.

### `GET /akun`

Returns all akun. 

### `GET /akun/{idAkun}`

Returns akun by id. 

### `POST /akun/baru`

Send data to akun, with field (username, password, nama). 

### `PUT /akun/{idAkun}`

Return akun by id, then update with newest field (nama, email, nomor-telepon, isi-aduan).

### `DELETE /akun/{idAkun}`

Delete akun by id. 

### `GET /kelas`

Returns all kelas. 

### `GET /kelas/{idKelas}`

Returns kelas by id. 

### `POST /kelas/baru`

Send data to kelas, with field (matkul, dosen). 

### `PUT /kelas/{idKelas}`

Return kelas by id, then update with newest field (matkul, dosen).

### `DELETE /kelas/{idKelas}`

Delete kelas by id. 

### `GET /jadwal`

Returns all jadwal. 

### `GET /jadwal/{idjadwal}`

Returns jadwal by id. 

### `POST /jadwal/baru`

Send data to jadwal, with field (ruang, hari, jam). 

### `PUT /jadwal/{idJadwal}`

Return jadwal by id, then update with newest field (ruang, hari, jam)

### `DELETE /jadwal/{idJadwal}`

Delete jadwal by id. 

### `GET /file`

Returns all file. 

### `GET /file/downloadFile/{idFile}`

Download file by id. 

### `POST /file/uploadFile`

Upload file with  form-data, (KEY : file, VALUE : MultiPart File). 


### `DELETE /file/{idFile}`

Delete file by id. 

### `GET /enroll`

Returns all enroll. 

### `GET /enroll/{idEnroll}`

return enroll by id. 

### `POST /enroll/baru/{idKelas}/{idAkun}`

Enroll with idKelas and idAkun. 


### `DELETE /enroll/{idEnroll}`

Delete enroll by id.

### `POST /login`

login to generate JWT.
