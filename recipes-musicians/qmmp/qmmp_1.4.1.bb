SUMMARY = "Qt based audio-player"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# Note: to support projectm, qtbase must be configured with desktop gl / gles
# won't work

DEPENDS += " \
    qttools-native \
    qtbase \
    qtmultimedia \
    ffmpeg \
    libsamplerate0 \
    curl \
    qtx11extras \
    taglib \
    libcdio \
    libcdio-paranoia \
    libcddb \
    libmad \
    faad2 \
    wavpack \
    libmms \
    libmodplug \
    libvorbis \
    projectm \
    enca \
    jack \
    soxr \
"

SRC_URI = " \
    http://qmmp.ylsoftware.com/files/${BPN}-${PV}.tar.bz2 \
    file://0001-Remove-freebsd-compilation-support.patch \
    file://0002-Hardcode-projectM-configuration-file-location.patch \
"
SRC_URI[md5sum] = "80f916d62ea9e60e5b83d9b930399128"
SRC_URI[sha256sum] = "2ad5e5ce790166a162b942fe64b734559c515ba06c1de5bef46b9713b3c8285c"

inherit cmake_qt5 mime-xdg

FILES_${PN} += " \
    ${datadir} \
    ${libdir}/qmmp-1.4 \
"
