# meta-luna
# Target filesystems path
gvim meta/conf/bitbake.conf

# Añadir paquetes a la instalación
gvim meta-luna/conf/layer.conf

TU_PAQUETE = " \
    tu_target1 \
    tu_target2 \
"

IMAGE_INSTALL_append += " \
        .
        .
    $(TU_PAQUETE) \
        .
        .
"

# Flashear SD
sudo umount /dev/mmcblk1p1
sudo umount /dev/mmcblk1p2
export MACHINE=raspberrypi2
export OETMP=/opt/yocto/poky/rpi-build/tmp
cd ./meta-rpi/scripts
./copy_boot.sh mmcblk1
./copy_rootfs.sh mmcblk1 qt5

# Environment
 $ . /opt/poky/2.3/environment-setup-cortexa7hf-neon-vfpv4-poky-linux-gnueabi

# Lugares varios
work/raspberrypi2-poky-linux-gnueabi/qt5-image/1.0-r0/rootfs/usr/include/RF24Mesh/RF24Mesh.h
work/cortexa7hf-neon-vfpv4-poky-linux-gnueabi/rf24mesh/1.0-r0/package/usr/include/RF24Mesh/RF24Mesh.h
work/cortexa7hf-neon-vfpv4-poky-linux-gnueabi/rf24mesh/1.0-r0/sysroot-destdir/usr/include/RF24Mesh/RF24Mesh.h
work/cortexa7hf-neon-vfpv4-poky-linux-gnueabi/rf24mesh/1.0-r0/packages-split/rf24mesh-dev/usr/include/RF24Mesh/RF24Mesh.h
work/cortexa7hf-neon-vfpv4-poky-linux-gnueabi/rf24mesh/1.0-r0/image/usr/include/RF24Mesh/RF24Mesh.h
work/cortexa7hf-neon-vfpv4-poky-linux-gnueabi/rf24mesh/1.0-r0/git/.pc/0001-rf24mesh-change-data-rate.patch/RF24Mesh.h
work/cortexa7hf-neon-vfpv4-poky-linux-gnueabi/rf24mesh/1.0-r0/git/RF24Mesh.h
