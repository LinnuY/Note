# 曾用过的Linux指令

## cp

```bash
cp 源文件 目标文件
cp ~/tmp.txt /tmp/tmp.txt
```

## pacman

1. ```bash
   pacman -U /var/cache/pacman/pkg/packagename-oldversion-*.pkg.tar.zst
   ```

# ssh

1. ```bash
   ssh root@127.0.0.1
   ```

2. ```bash
   scp 源文件 目标文件
   scp ./tmp.txt root@127.0.0.1:~/tmp.txt
   ```

## user

1. add

   ```bash
   useradd -m -G wheel -s /bin/zsh passenger 
   ```

2. delete

   ```bash
   userdel passenger
   ```

3. 修改用户密码

   ```bash
   passwd passenger
   ```


## tar

1. 解压tar.gz

   ```bash
   tar -zxvf pdsh-2.34.tar.gz
   ```

2. 解压tar.bz2

   ```bash
   tar -jxvf pdsh-2.34.tar.bz2
   ```


## 修改本机hostname

```bash
sudo echo archlinux > /etc/hostname
```

