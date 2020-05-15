SUMMARY = "Qt5 based audio-player"
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
SRC_URI[md5sum] = "2add4ac23e4b850b0d1958c4d242ff01"
SRC_URI[sha256sum] = "a8b9cda1fe137f9b50acc54bc02ac1f3ba89051f828f40f5dc9a9056cab4308f"

inherit cmake_qt5 mime-xdg

FILES_${PN} += " \
    ${datadir} \
    ${libdir}/qmmp-1.4 \
"
