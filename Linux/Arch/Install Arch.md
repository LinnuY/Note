# 安装Arch步骤:



1. 验证启动模式,若执行以下命令没有错误,则系统是以 UEFI 模式启动.

   ```bash
   ls /sys/firmware/efi/efivars
   ```

2. 建立磁盘分区

   ```bash
   lsblk
   cfdisk /dev/sda
   ```

3. 分成三个区,对三个区分别格式化,挂载在/mnt,/mnt/home,/mnt/boot

   ```bash
   mkfs.ext4 /dev/sda1
   mkfs.ext4 /dev/sda2
   mkfs.vfat /dev/sda3
   mount /dev/sda1 /mnt
   mkdir /mnt/boot
   mkdir /mnt/home
   mount /dev/sda3 /mnt/boot
   mount /dev/sda2 /mnt/home
   ```

4. 将pacman换到更快的源并更新pacman

   ```bash
   vim /etc/pacman.d/mirrorlist
   pacman -Syy
   ```

5. 安装必须的软件包

   ```bash
   pacstrap /mnt base base-devel linux linux-firmware
   ```

6. 配置系统

   ```bash
   genfstab -U /mnt >> /mnt/etc/fstab
   arch-chroot /mnt
   ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
   hwclock --systohc
   pacman -S vim
   vim /etc/locale.gen
   locale-gen
   echo LANG=en_US.UTF-8 > /etc/locale.conf
   echo LinuYArch > /etc/hostname
   passwd
   pacman -S dhcpcd dhcp
   systemctl enable dhcpcd
   pacman -S grub efibootmgr
   grub-install --target=x86_64-efi --efi-directory=/boot --bootloader-id=ArchLinux
   grub-mkconfig -o /boot/grub/grub.cfg
   ```

7. 重启

   ```bash
   exit
   umount -R /mnt
   reboot
   ```

   

