<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
            <script src="https://kit.fontawesome.com/32aa2b8683.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
            <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
            <link rel="stylesheet" href="/css/style.css">
            <title>회원가입 페이지</title>
        </head>

        <body>
            <div class="mx-auto width-53">
                <div class="mx-5" style="border: solid black;">
                    <div class="container w-50">
                        <div class="card-header d-flex justify-content-around my-4">
                            <div class="fs-4">
                                <a href="/user/login">로그인</a>
                            </div>
                            <div class="fs-4">
                                <a href="/user/join">회원가입</a>
                            </div>
                        </div>
                        <form action="/join" method="post">
                            <div class="d-flex form-group mb-2">
                                <input type="email" name="email" class="form-control" placeholder="Enter email"
                                    id="email">
                                <button type="button" class="badge bg-secondary ms-2">중복확인</button>
                            </div>

                            <div class="form-group mb-2">
                                <input type="text" name="name" class="form-control" placeholder="Enter name" id="name">
                            </div>

                            <div class="form-group mb-2">
                                <input type="password" name="password" class="form-control" placeholder="Enter password"
                                    id="password">
                            </div>

                            <div class="form-group mb-2">
                                <input type="password" class="form-control" placeholder="Enter passwordCheck"
                                    id="passwordCheck">
                            </div>

                            <div class="form-group mb-2">
                                <input type="date" name="birth" class="form-control" placeholder="Enter birth"
                                    id="birth">
                            </div>

                            <div class="form-group mb-2">
                                <input type="tel" name="tel" class="form-control" placeholder="Enter tel" id="tel">
                            </div>

                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                <label class="form-check-label" for="flexCheckDefault">
                                    서비스 이용약관 관련 전체동의
                                </label>
                            </div>
                            <hr />
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                                <label class="form-check-label" for="flexCheckChecked">
                                    (필수) 이용약관 동의
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                                <label class="form-check-label" for="flexCheckChecked">
                                    (필수) 개인정보 수집 및 이용 동의
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                                <label class="form-check-label" for="flexCheckChecked">
                                    (필수) 14세 이상 연령
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                                <label class="form-check-label" for="flexCheckChecked">
                                    (선택) 이메일 수신 동의
                                </label>
                            </div>
                            <div class="d-grid gap-2 mb-4">
                                <input class=" btn btn-primary" type="submit" value="회원가입"></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>