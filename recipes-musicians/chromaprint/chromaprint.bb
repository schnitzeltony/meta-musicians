SUMMARY = "Chromaprint is library that extracts fingerprints from audio sources"
HOMEPAGE = "https://acoustid.org/chromaprint"
LICENSE = "MIT & LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=5d50f7a9fde1110fa1756b0f5faa26f2"

inherit cmake

DEPENDS += " \
    fftw \
    ffmpeg \
"

SRC_URI = "git://github.com/acoustid/chromaprint.git;branch=master;protocol=https"
SRCREV = "516e3b31c7fa6e822035ea3b3e31f9c7f51ef4b6"
PV = "1.5.0"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
    ${@bb.utils.contains('TUNE_FEATURES', 'neon', '-DFFT_LIB=fftw3f', '', d)} \
    -DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')} \
"
