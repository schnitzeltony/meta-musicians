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
    https://qmmp.ylsoftware.com/files/${BPN}/1.5/${BPN}-${PV}.tar.bz2 \
    file://0001-Remove-freebsd-compilation-support.patch \
    file://0002-Hardcode-projectM-configuration-file-location.patch \
"
SRC_URI[sha256sum] = "f3dc676039b5f190e6a87377a6b2bd2bcca122d1659b5f22668c7a284bb91f43"

inherit cmake_qt5 mime-xdg

FILES:${PN} += " \
    ${datadir} \
    ${libdir}/qmmp-1.5 \
"
