# Arch Linux 安装 GNOME 图形化界面

1. 安装xorg和gnome

   ```bash
   pacman -S xorg
   pacman -S gnome
   pacman -S gnome-extra
   ```

2. 管理器

   ```bash
   systemctl enable gdm
   systemctl enable NetworkManager
   ```

3. 创建用户

   ```bash
   useradd -m -G wheel -s /bin/zsh passenger
   vim /etc/sudoers
   ```