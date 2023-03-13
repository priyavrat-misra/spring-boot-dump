let SessionLoad = 1
if &cp | set nocp | endif
let s:so_save = &so | let s:siso_save = &siso | set so=0 siso=0
let v:this_session=expand("<sfile>:p")
silent only
silent tabonly
exe "cd " . escape(expand("<sfile>:p:h"), ' ')
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
set shortmess=aoO
argglobal
%argdel
$argadd ~/spring-boot-dump/UsersApplication/src/main/java/com/example/usersapplication/User.java
edit src/main/java/com/example/usersapplication/User.java
set splitbelow splitright
wincmd _ | wincmd |
vsplit
wincmd _ | wincmd |
vsplit
2wincmd h
wincmd w
wincmd _ | wincmd |
split
1wincmd k
wincmd w
wincmd w
wincmd _ | wincmd |
split
1wincmd k
wincmd w
set nosplitbelow
set nosplitright
wincmd t
set winminheight=0
set winheight=1
set winminwidth=0
set winwidth=1
exe 'vert 1resize ' . ((&columns * 41 + 86) / 172)
exe '2resize ' . ((&lines * 29 + 20) / 41)
exe 'vert 2resize ' . ((&columns * 70 + 86) / 172)
exe '3resize ' . ((&lines * 9 + 20) / 41)
exe 'vert 3resize ' . ((&columns * 70 + 86) / 172)
exe '4resize ' . ((&lines * 22 + 20) / 41)
exe 'vert 4resize ' . ((&columns * 59 + 86) / 172)
exe '5resize ' . ((&lines * 16 + 20) / 41)
exe 'vert 5resize ' . ((&columns * 59 + 86) / 172)
argglobal
let s:l = 1 - ((0 * winheight(0) + 19) / 39)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
wincmd w
argglobal
if bufexists("src/main/java/com/example/usersapplication/UsersController.java") | buffer src/main/java/com/example/usersapplication/UsersController.java | else | edit src/main/java/com/example/usersapplication/UsersController.java | endif
let s:l = 1 - ((0 * winheight(0) + 14) / 29)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
wincmd w
argglobal
terminal ++curwin ++cols=70 ++rows=9 
let s:l = 1 - ((0 * winheight(0) + 4) / 9)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
wincmd w
argglobal
if bufexists("src/main/java/com/example/usersapplication/UsersDB.java") | buffer src/main/java/com/example/usersapplication/UsersDB.java | else | edit src/main/java/com/example/usersapplication/UsersDB.java | endif
let s:l = 1 - ((0 * winheight(0) + 11) / 22)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
wincmd w
argglobal
if bufexists("src/main/java/com/example/usersapplication/UsersApplication.java") | buffer src/main/java/com/example/usersapplication/UsersApplication.java | else | edit src/main/java/com/example/usersapplication/UsersApplication.java | endif
let s:l = 1 - ((0 * winheight(0) + 8) / 16)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
wincmd w
exe 'vert 1resize ' . ((&columns * 41 + 86) / 172)
exe '2resize ' . ((&lines * 29 + 20) / 41)
exe 'vert 2resize ' . ((&columns * 70 + 86) / 172)
exe '3resize ' . ((&lines * 9 + 20) / 41)
exe 'vert 3resize ' . ((&columns * 70 + 86) / 172)
exe '4resize ' . ((&lines * 22 + 20) / 41)
exe 'vert 4resize ' . ((&columns * 59 + 86) / 172)
exe '5resize ' . ((&lines * 16 + 20) / 41)
exe 'vert 5resize ' . ((&columns * 59 + 86) / 172)
tabnext 1
badd +0 src/main/java/com/example/usersapplication/User.java
badd +0 src/main/java/com/example/usersapplication/UsersDB.java
badd +0 src/main/java/com/example/usersapplication/UsersController.java
badd +0 src/main/java/com/example/usersapplication/UsersApplication.java
if exists('s:wipebuf') && len(win_findbuf(s:wipebuf)) == 0
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20 shortmess=filnxtToOS
set winminheight=1 winminwidth=1
let s:sx = expand("<sfile>:p:r")."x.vim"
if file_readable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &so = s:so_save | let &siso = s:siso_save
nohlsearch
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
